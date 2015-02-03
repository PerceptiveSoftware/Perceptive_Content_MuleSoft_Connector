/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package com.perceptivesoftware.mule.connector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Optional;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;

import org.mule.api.annotations.param.Default;

import com.google.common.base.Strings;
import com.perceptivesoftware.mule.connector.client.IntegrationServerClient;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.document.Document;
import com.perceptivesoftware.mule.connector.client.model.document.Page;
import com.perceptivesoftware.mule.connector.client.model.document.Property;
import com.perceptivesoftware.mule.connector.client.model.document.RenameDocument;
import com.perceptivesoftware.mule.connector.client.model.documenttype.DocumentTypeInfo;
import com.perceptivesoftware.mule.connector.client.model.documenttypedetails.DocumentTypeDetails;
import com.perceptivesoftware.mule.connector.client.model.drawer.DrawerInfo;
import com.perceptivesoftware.mule.connector.client.model.drawerdetails.DrawerDetails;
import com.perceptivesoftware.mule.connector.client.model.formpresentation.FormPresentation;
import com.perceptivesoftware.mule.connector.client.model.formpresentation.FormPresentationInfo;
import com.perceptivesoftware.mule.connector.client.model.formpresentation.FormPresentations;
import com.perceptivesoftware.mule.connector.client.model.forms.FormInfo;
import com.perceptivesoftware.mule.connector.client.model.forms.Forms;
import com.perceptivesoftware.mule.connector.client.model.property.PropertyInfo;
import com.perceptivesoftware.mule.connector.client.model.property.PropertyList;
import com.perceptivesoftware.mule.connector.client.model.routeitem.RouteItem;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateKeys;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateProperty;
import com.perceptivesoftware.mule.connector.client.model.viewdetails.ViewDetails;
import com.perceptivesoftware.mule.connector.client.model.viewresults.ViewResults;
import com.perceptivesoftware.mule.connector.client.model.viewresults.VslRequest;
import com.perceptivesoftware.mule.connector.client.model.views.ViewInfo;
import com.perceptivesoftware.mule.connector.client.model.workflowitem.AddWorkflowItem;
import com.perceptivesoftware.mule.connector.client.model.workflowitem.WorkflowItem;
import com.perceptivesoftware.mule.connector.client.model.workflowqueueforms.WorkflowQueueForm;
import com.perceptivesoftware.mule.connector.client.model.workflowqueues.WorkflowQueueInfo;

/**
 * The Perceptive Content MuleSoft Connector
 * 
 * Provides the following functionality: A RESTful client for connecting to
 * Perceptive Content using Integration Server.
 * 
 * @author Perceptive Software
 */
@Connector(name="perceptive-content-mulesoft", schemaVersion="1.0", friendlyName="Perceptive Content")
public class PerceptiveContentMuleSoftConnector
{
	/**
     * Configurable
     */
    @Configurable
    @Default("http://<app-server-name>:<port>/integrationserver")
    private String url;
    
    private String user;
    private String password;
    
    IntegrationServerClient client = null;
    private String connectionId = "";
    
    static final private Log logger = LogFactory
            .getLog(PerceptiveContentMuleSoftConnector.class);
    
    /**
     * Connect - Make a connection with Perceptive Content Integration Server
     *
     * @param username The Perceptive Content User
     * @param password The password for the specified Perceptive Connect User
     * @throws ConnectionException Thrown if connection fails
     */
    @Connect
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {

    	// Disconnect any existing connection
    	disconnect();
    	
    	this.user = username;
    	this.password = password;
    	
    	client = new IntegrationServerClient(getUrl(), getUser(), getPassword());
    	try {
    		setConnected(client.connect());
		} catch (IntegrationServerConnectorException e) {
			setUnconnected();
			throw new ConnectionException(ConnectionExceptionCode.UNKNOWN, "", 
					String.format("Failed to connect to server [url: %s, user: %s]", getUrl(), getUser()), 
					e);
		}
    }
    
    /**
     * Disconnect - disconnect from Perceptive Content Integration Server
     */
    @Disconnect
    public void disconnect() {
    	if(isConnected()) {
    		try {
				client.disconnect();
			} catch (IntegrationServerConnectorException e) {
				// meh
			}
    	}
    	
    	client = null;
    	setUnconnected();
    }

    /**
     * Are we connected?
     */
    @ValidateConnection
    public boolean isConnected() {
        return !Strings.isNullOrEmpty(connectionId);
	}

	/**
	 * Returns a Document from Perceptive Content
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-document}
	 * @param documentId The Perceptive Content Document ID
	 * @return Document Information related to the Perceptive Content Document
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Get Document")
	public Document getDocument(String documentId) throws IntegrationServerConnectorException  {
        Document document = client.getDocumentEndpoint().getDocument(documentId);
        
        // "Enrich" the out-going data with property names
        PropertyList properties = client.getPropertyEndpoint().getAllProperties();
        for(Property property : document.getProperties()) {
            PropertyInfo info = properties.findPropertyId(property.getId());
            property.setName(info.getName());
        }
        
        return document;
	}
	
	/**
	 * Rename the Perceptive Document Property "name".
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:rename-document}
	 * @param documentName The new name for the Document
	 * @param documentId The Perceptive Content Document ID
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Rename Document")
	public void renameDocument(String documentId, String documentName) throws IntegrationServerConnectorException {
		RenameDocument docName =  new RenameDocument();
		docName.setName(documentName);
		
		client.getDocumentEndpoint().renameDocument(documentId, docName);	
	}

	/**
	 * Update a Perceptive Content Document's keys 
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:set-document-keys}
	 * @param documentId The Perceptive Content Document ID
	 * @param keys The object UpdateKeys to set the Perceptive Content Document Keys 
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Set Keys")
	public void setDocumentKeys(String documentId, UpdateKeys keys) throws IntegrationServerConnectorException {
		client.getDocumentEndpoint().setKeys(documentId, keys);			
	}

	/** 
	 * Update the Perceptive Content Document's custom properties.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:set-custom-properties}
	 * @param documentId The Perceptive Content Document ID
	 * @param customProperties The map of custom property names and values to set the Perceptive Content Document Custom Properties
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Set Custom Properties")
	public void setCustomProperties(String documentId, Map<String, String> customProperties)  throws IntegrationServerConnectorException{
		List<UpdateProperty> updateProperties = createUpdateProperties(customProperties);
		client.getDocumentEndpoint().setCustomProperties(documentId, updateProperties);
	}

	/**
	 * Create Document returns the Document ID of the newly created document in Perceptive Content.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:create-document}
	 * @param  documentName This will be the name for the Perceptive Content Document (optional)
	 * @param  locationId The Drawer or Folder ID of the document (optional)
	 * @param  keys  The UpdateKeys object to set Perceptive Content Document Keys
	 * @param  properties The map of custom property names and values to set the Perceptive Content Document Custom Properties
	 * @return String The Perceptive Content Document ID
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Create Document")
	public String createDocument(@Optional String documentName, @Optional String locationId,
			UpdateKeys keys, @Optional Map<String, String> properties)  throws IntegrationServerConnectorException {
		
		List<UpdateProperty> updateProperties = createUpdateProperties(properties);
		return client.getDocumentEndpoint().createDocument(documentName, locationId, keys, updateProperties);
	}
	
	private List<UpdateProperty> createUpdateProperties(
			Map<String, String> properties)
			throws IntegrationServerConnectorException {

		List<UpdateProperty> updateProperties = new ArrayList<UpdateProperty>();

		PropertyList propertyList = client.getPropertyEndpoint()
				.getAllProperties();

		if (properties != null) {
			for (String key : properties.keySet()) {
				String value = properties.get(key);
				PropertyInfo propInfo = propertyList.findPropertyName(key);

				UpdateProperty prop = new UpdateProperty();
				prop.setId(propInfo.getId());
				prop.setValue(value);
				prop.setType(propInfo.getType());

				updateProperties.add(prop);
			}
		}

		return updateProperties;
	}

	/**
	 * Add a page to a a Perceptive Content Document
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:add-page-to-document}
	 * @param documentId The Perceptive Content Document ID 
	 * @param pageName This is what the name of the page will be called in the Perceptive Content Document. (optional)
	 * @param filePath The file location to the page to be added
	 * @throws FileNotFoundException Thrown if the file fails to open
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Add Page")
	public void addPageToDocument(String documentId, String filePath,
			@Optional String pageName)
			throws IntegrationServerConnectorException, FileNotFoundException {

		if (Strings.isNullOrEmpty(pageName)) {
			pageName = FilenameUtils.getName(filePath);
		}

		FileInputStream input = new FileInputStream(filePath);
		client.getDocumentEndpoint().addPage(documentId, pageName, input);
	}
	
	/**
	 * Replace an existing document page in Perceptive Content Document
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:replace-document-page}
	 * @param documentId The Perceptive Content Document ID 
	 * @param existingPageName This is the existing name of the page in Perceptive Content that will be replaced
	 * @param filePath The file location to the page to be added
	 * @param replacementPageName This is the replacement name for the page that is being replaced in Perceptive Content page (optional)
	 * @throws FileNotFoundException Thrown if the file fails to open
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Replace Page")
	public void replaceDocumentPage(String documentId, String existingPageName, String filePath,
			@Optional String replacementPageName)
			throws IntegrationServerConnectorException, FileNotFoundException {

		if (Strings.isNullOrEmpty(replacementPageName)) {
			replacementPageName = FilenameUtils.getName(filePath);
		}

		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		
		String pageId = findPageId( documentId, existingPageName );
		
		client.getDocumentEndpoint().replacePage(documentId, pageId, replacementPageName, file.length(), input);
	}	

	/**
	 * Get a Perceptive Content Document's page by ID
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-page-by-id}
	 * @param documentId The Perceptive Content Document ID 
	 * @param pageNumber This is the page number in the document to get
	 * @return InputStream An input stream for the requested page
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Get Page")
	public InputStream getPageById(String documentId, int pageNumber)  throws IntegrationServerConnectorException {			
		return client.getDocumentEndpoint().getPage(documentId, pageNumber);	
	}
	/**
	 * Delete Perceptive Content Document
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:delete-document}
	 * @param documentId The Document ID to delete
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Delete Document")
	public void deleteDocument(String documentId)  throws IntegrationServerConnectorException {			
		client.getDocumentEndpoint().deleteDocument(documentId);	
	}
	
	/**
	 * Deletes a Page from a Perceptive Content Document by Number
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:delete-page-by-number}
	 * @param documentId The Perceptive Content Document ID 
	 * @param pageNumber The page number to delete
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Delete Page by Number")
	public void deletePageByNumber(String documentId, int pageNumber)  throws IntegrationServerConnectorException {			
		client.getDocumentEndpoint().deletePageByNumber(documentId, pageNumber);	
	}
	
	/**
	 * Deletes a Page from a Perceptive Content Document by ID
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:delete-page-by-id}
	 * @param documentId The Perceptive Content Document ID 
	 * @param pageId The page id to delete
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Delete Page by Id")
	public void deletePageById(String documentId, String pageId)  throws IntegrationServerConnectorException {			
		client.getDocumentEndpoint().deletePageById(documentId, pageId);	
	}
	
	/**
	 * Deletes a Page from a Perceptive Content Document by Name
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:delete-page-by-name}
	 * @param documentId The Perceptive Content Document ID 
	 * @param pageName The page by name to delete
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Delete Page by Name")
	public void deletePageByName(String documentId, String pageName)  throws IntegrationServerConnectorException {	
		String pageId = findPageId(documentId, pageName);
		client.getDocumentEndpoint().deletePageById(documentId, pageId);	
	}
	
	
	/**
	 * Create Document with page data returns the Document ID created by Perceptive Content.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:create-doc-with-page}
	 
	 * @param documentName This will be the name for the Perceptive Content Document (optional)
	 * @param locationId The Drawer or Folder ID of the document (optional)
	 * @param  keys  The UpdateKeys object to set Perceptive Content Document Keys
	 * @param  properties The map of custom property names and values to set the Perceptive Content Document Custom Properties
	 * @param filePath The file location to the page data
	 * @param pageName This is what the name of the page will be called in the Perceptive Content Document (optional)
	 * @return String The document ID
	 * @throws FileNotFoundException Thrown if file path not found
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Document - Create Document with Page")
	public String createDocumentWithPage(@Optional String documentName, @Optional String locationId,
			UpdateKeys keys, @Optional Map<String, String> properties, String filePath, @Optional String pageName)  
					throws IntegrationServerConnectorException, FileNotFoundException {
		
		if(Strings.isNullOrEmpty(pageName)) {
			pageName = FilenameUtils.getName(filePath);
		}
		
		FileInputStream input = new FileInputStream(filePath);
        List<UpdateProperty> updateProperties = createUpdateProperties(properties);

        return client.getDocumentEndpoint().createDocument(documentName, locationId, keys, updateProperties, input, pageName);
	}
	/**
	 * Returns a list of DocumentTypeInfo  from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-document-type-list}
	 * @return Document The Document info
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "DocumentType - Get Document Type List")
	public List<DocumentTypeInfo> getDocumentTypeList() throws IntegrationServerConnectorException  {
		return client.getDocumentTypeEndpoint().getDocumentTypeList().getDocumentTypes();
	}
	
	/**
	 * Returns a DocumentTypeDetails object  from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-document-type-details}
	 * @param documentTypeName The name of the documentType
	 * @return Document The Document info
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "DocumentType - Get Document Type Details")
	public DocumentTypeDetails getDocumentTypeDetails(String documentTypeName) throws IntegrationServerConnectorException  {		
		
		List<DocumentTypeInfo> docTypes = client.getDocumentTypeEndpoint().getDocumentTypeList().getDocumentTypes();		
		String docTypeId = client.getDocumentTypeEndpoint().findDocTypeId(documentTypeName, docTypes);

		return client.getDocumentTypeEndpoint().getDocumentTypeDetails(docTypeId);
	}
	
	/**
	 * Returns a DocumentTypeDetails object from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-document-type-details-by-id}
	 * @param documentTypeId The name of the documentType
	 * @return Document The Document info
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "DocumentType - Get Document Type Details By Id")
	public DocumentTypeDetails getDocumentTypeDetailsById(String documentTypeId) throws IntegrationServerConnectorException  {		
		return client.getDocumentTypeEndpoint().getDocumentTypeDetails(documentTypeId);
	}
	/**
	 * Returns a list of DrawerInfo objects from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-drawer-list}
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 * @return Return List of Drawers
	 */
	@Processor(friendlyName = "Drawer - Get List of Drawers")
	public List<DrawerInfo> getDrawerList() throws IntegrationServerConnectorException  {
		return client.getDrawerEndpoint().getDrawerList().getDrawers();
	}
	
	/**
	 * Returns a DrawerDetails object from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-drawer-details-by-name}
	 * @param drawerName The name of the drawer
	 * @return DrawerDetails The Drawer details
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Drawer - Get Drawer Details By Name")
	public DrawerDetails getDrawerDetailsByName(String drawerName) throws IntegrationServerConnectorException  {		
		
		List<DrawerInfo> docTypes = client.getDrawerEndpoint().getDrawerList().getDrawers();	
		String drawerId = client.getDrawerEndpoint().findDrawerId(drawerName, docTypes);

		return client.getDrawerEndpoint().getDrawerDetails(drawerId);
	}
	
	/**
	 * Returns a DrawerDetails object from Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-drawer-details-by-id}
	 * @param drawerId The ID of the drawer
	 * @return DrawerDetails The Drawer details
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Drawer - Get Drawer Details By Id")
	public DrawerDetails getDrawerDetailsById(String drawerId) throws IntegrationServerConnectorException  {		
		return client.getDrawerEndpoint().getDrawerDetails(drawerId);
	}
	
	
	
	/**
	 * Returns a list of FormInfo objects from Perceptive Content
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-form-list}
	 * @return List<FormInfo> The list of forms
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Forms - Get Form List")
	public List<FormInfo> getFormList() throws IntegrationServerConnectorException {
		return client.getFormsEndpoint().getAllForms().getForms();	
	}	 		


	/**
	 * Gets the XML form data for a Form ID associated with a given Document ID
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-form-data}
	 * @param formName The name of the Form in Perceptive Content
	 * @param documentId  The Perceptive Content Document ID
	 * @return InputStream An XML file stream
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Forms - Get Form Data")
	public InputStream getFormData(String formName, String documentId) throws IntegrationServerConnectorException {
		Document doc = client.getDocumentEndpoint().getDocument(documentId);
		String formId = findFormId( formName );
		return client.getFormsEndpoint().getFormData(documentId, formId, Integer.toString(doc.getInfo().getVersion()));
	}	
	
	/**
	 * Gets the XML form data for a Form ID associated with a given Document ID in Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-form-data}
	 * @param formId The Form ID in Perceptive Content
	 * @param documentId  The Perceptive Content Document ID
	 * @return InputStream An XML file stream
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Forms - Get Form Data by form Id")
	public InputStream getFormDataByFormId(String formId, String documentId) throws IntegrationServerConnectorException {
		Document doc = client.getDocumentEndpoint().getDocument(documentId);
		return client.getFormsEndpoint().getFormData(documentId, formId, Integer.toString(doc.getInfo().getVersion()));
	}	
	
	/**
	 * Overwrite the Form in Perceptive Content for the given document Id
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:set-form-data}
	 * @param documentId The Perceptive Content Document Id
	 * @param filePath The file location to the file that is being uploaded
	 * @param formName The Name of the form in Perceptive Content
	 * @throws IntegrationServerConnectorException Comment for Exception	
	 * @throws FileNotFoundException Did not find file
	 */
	@Processor(friendlyName = "Forms - Update Form Data")
	public void setFormData(String formName, String documentId, String filePath) throws IntegrationServerConnectorException, FileNotFoundException {
		Document doc = client.getDocumentEndpoint().getDocument(documentId);
		FileInputStream formData = new FileInputStream(filePath);
		String formId = findFormId(formName);
		client.getFormsEndpoint().setFormData(documentId, formId, Integer.toString(doc.getInfo().getVersion()),formData);	
	}	 		
	
	/**
	 *  Returns the data definition of a form.   The Data definition is formated XML 
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-data-definition}
	 * @param formName the Name of the Form in Perceptive Content
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 * @throws FileNotFoundException Comment for Exception
	 * @param presentationName the name of the form presentation 
	 * @return Return comments
	 */
	@Processor(friendlyName = "Forms - Get Data Definition")
	public InputStream getDataDefinition(String formName, @Optional String presentationName) throws IntegrationServerConnectorException, FileNotFoundException {

		String formId = findFormId(formName);

		FormPresentations formPresentation = null;
		if (!formId.isEmpty()) {
			formPresentation = client.getFormsEndpoint().getFormPresentation(
					formId);
		}

		//ImageNow Service just takes the first presentation optionally if you know the presentationName and fill it out we will use that
		String presentationId = "";
		if (presentationName != null && !presentationName.isEmpty()) {
			for (FormPresentation presentation : formPresentation
					.getPresentations()) {
				if (presentationName.equals(presentation.getName())) {
					presentationId = presentation.getId();
					break;
				}
			}
		} else {
			presentationId = formPresentation.getPresentations().get(0).getId();
		}

		FormPresentationInfo presentation = client.getFormsEndpoint()
				.getPresentationInfo(formId, presentationId);

		return client.getFormsEndpoint().getDataDefinition(formId,
				presentationId, presentation.getDataDefinition().getId());
	
	}

	/**
	 * Return a list of all Custom Properties ( PropertyInfo ) defined in Perceptive Content 
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-property-list}
	 * @return List<PropertyInfo> The list of custom properties
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "Property - Get Custom Property List")
	public List<PropertyInfo> getPropertyList() throws IntegrationServerConnectorException {
		return client.getPropertyEndpoint().getAllProperties().getProperties();
	}
	

	/**
	 * Return a list of all views (ViewInfo) available in Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-view-list}
	 * @return List<ViewInfo> The list of Views
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "View - Get List of Views")
	public List<ViewInfo> getViewList() throws IntegrationServerConnectorException {
		return client.getViewEndpoint().getViews().getViews();
	}

	/**
	 * Returns a ViewDetails object
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-view-by-id}
	 * @param viewId the Id of the View
	 * @return List<ViewInfo> The list of views
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "View - Get View by Id")
	public ViewDetails getViewById(String viewId) throws IntegrationServerConnectorException {
		return client.getViewEndpoint().getViewById(viewId);
	}
	
	/**
	 *  Returns a ViewDetails object
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-view-by-name}
	 * @param viewName the Name of the View in Perceptive Content
	 * @return ViewDetails The details of view
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "View - Get View by Name")
	public ViewDetails getViewByName(String viewName) throws IntegrationServerConnectorException {
		List<ViewInfo> views = client.getViewEndpoint().getViews().getViews(); 
		String viewId = client.getViewEndpoint().findView(viewName, views);
		
		return client.getViewEndpoint().getViewById(viewId);
	}

	/**
	 * A ViewResults object is returned.  As a result of running the specified view in Perceptive Content
	 *  
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:run-view-by-name}
	 * @param viewName the Name of the View in Perceptive Content
	 * @param vslText the VSL to describe the request example:  "[drawer] = 'Invoices' AND ( {Invoice Amount} > '10000' OR [creationUser] = 'jdoe' )"
	 * @return ViewResults The details of view
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "View - Run View by Name")
	public ViewResults runViewByName(String viewName, @Optional String vslText) throws IntegrationServerConnectorException {
		List<ViewInfo> views = client.getViewEndpoint().getViews().getViews(); 
		String viewId = client.getViewEndpoint().findView(viewName, views);
		
		VslRequest vsl = new VslRequest();
		
		if ( vslText == null )
			vsl.setVslText("");
		else vsl.setVslText(vslText);
		
		return client.getViewEndpoint().runView(viewId, vsl);
	}

	
	/**
	 * Gets information about a given workflow item.  Useful for converting
	 * a workflow item ID into a item ID.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-workflow-item-info}
	 * @param workflowItemId The ID of an item in Workflow in Perceptive Content
	 * @return String Perceptive Content Document ID corresponding to the Workflow Item ID
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "WorkflowItem - Get Workflow Item Info")
	public WorkflowItem GetWorkflowItemInfo(String workflowItemId)
			throws IntegrationServerConnectorException {
		return client.getWorkflowItemEndpoint().getWorkflowItem(workflowItemId);
	}

	/**
	 * Gets information about a given workflow item.  Useful for converting
	 * a workflow item ID into a item ID.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:remove-from-workflow}
	 * @param workflowItemId The ID of an item in Workflow in Perceptive Content
	 * @param workflowQueueName The name of the Workflow Queue in Perceptive Content
	 * @return String Perceptive Content Document ID corresponding to the Workflow Item ID
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "WorkflowItem - Remove WorkflowItem from workflow")
	public void removeFromWorkflow(String workflowItemId, String workflowQueueName)
			throws IntegrationServerConnectorException {
		
		String queueId = findWorkflowQueId(workflowQueueName);
		client.getWorkflowItemEndpoint().removeFromWorkflow(workflowItemId, queueId);
	}


	/**
	 * Route an existing workflow item to a defined queue in Perceptive Content
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:route-workflow-item}
	 * 
	 * @param workflowItemId The ID of the item in Perceptive Content Workflow to route
	 * @param originQueueId The ID of the Workflow Queue the Perceptive Content Document is currently in.
	 * @param originQueueName The Name of the Workflow Queue the Perceptive Content Document is currently in. 
	 * @param destinationQueueId The ID of the Workflow Queue in Perceptive Content to route the document to.
	 * @param routeReason This is a brief description of the reason for routing
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "WorkflowItem - Route Item")
	public void routeWorkflowItem(String workflowItemId, String originQueueId,
			String originQueueName, String destinationQueueId, String routeReason)
					throws IntegrationServerConnectorException {

		RouteItem routeItem = new RouteItem();
		routeItem.setDestinationWorkflowQueueId(destinationQueueId);
		routeItem.setOriginWorkflowQueueId(originQueueId);
		routeItem.setOriginWorkflowQueueName(originQueueName);
		routeItem.setReason(routeReason);
		routeItem.setRouteType("MANUAL"); // routeType

		client.getWorkflowItemEndpoint().routeItem(workflowItemId, routeItem);
	}

	/**
	 * Add a document to Perceptive Content Workflow Queue
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:add-item-to-workflow}
	 * @param workflowQueueName The name of the Workflow Queue in Perceptive Content to add the document to 
	 * @param itemPriority the priority ("LOW", "MEDIUM", or "HIGH" ) to set when adding to workflow 
	 * @param itemType The type of object ( "DOCUMENT" )
	 * @param objectId Perceptive Content Document ID that is being added to Perceptive Content Workflow
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 * @return Return String workflowItemId
	 */
	@Processor(friendlyName = "WorkflowItem - Add Item to workflow")
	public String addItemToWorkflow(String objectId, @Default("#['DOCUMENT']")String itemType,
			String workflowQueueName, @Default("#['LOW']") String itemPriority)
					throws IntegrationServerConnectorException {

		String workflowQueueId = findWorkflowQueId(workflowQueueName);
		
		AddWorkflowItem item = new AddWorkflowItem();
		item.setItemPriority(itemPriority);
		item.setObjectId(objectId);
		item.setItemType(itemType);
		item.setWorkflowQueueId(workflowQueueId);
				
		return client.getWorkflowItemEndpoint().addItemToWorkflow(item);
	}
	
	/**
	 * Returns a list of Perceptive Content Workflow Queues ( WorkflowQueueInfo )
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-workflow-queue}
	 * @return List<WorkflowQueueInfo> The list of Workflow Queues
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "WorkflowQueue - Get List of Workflow Queues")
	public List<WorkflowQueueInfo> getWorkflowQueues() throws IntegrationServerConnectorException {
		return client.getWorkflowQueueEndpoint().getAllWorkflowQueue().getWorkflowQueues();		
	}

	/**
	 *  Returns a list of Perceptive Content forms tied to a specifi workflow queue.
	 * 
	 * {@sample.xml ../../../doc/perceptive-content-mulesoft-connector.xml.sample perceptive-content:get-workflow-queue-forms}
	 * @param queueId A queue ID
	 * @return List<WorkflowQueueForm>  A list of Workflow Queue Forms
	 * @throws IntegrationServerConnectorException Thrown if call fails
	 */
	@Processor(friendlyName = "WorkflowQueue - Get Form List for Queue")
	public List<WorkflowQueueForm> getWorkflowQueueForms(String queueId) throws IntegrationServerConnectorException {
		return client.getWorkflowQueueEndpoint().getWorkflowQueueForms(queueId).getForms();	
	}	 	
    private void setConnected(String connectionId) {
    	this.connectionId = connectionId;
    }
    
    private void setUnconnected() {
    	this.connectionId = "";
    }

    /**
     * Used during debugging
     */
    @ConnectionIdentifier
    public String connectionId() {
        return connectionId;
    }
    
    /**
     * Set property
     *
     * @param myProperty My property
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get property
     */
    public String getUrl() {
        return this.url;
    }    
    
    public String getUser() {
    	return this.user;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void log(String msg) {
		getLogger().info(msg);
	}

	public static Log getLogger() {
		return logger;
	}
	
	private String findFormId(String formName) throws IntegrationServerConnectorException
	{
		Forms allForms = client.getFormsEndpoint().getAllForms();
		String formId = "";

		for (FormInfo form : allForms.getForms()) {
			if (formName.equals(form.getName())) {
				formId = form.getId();
				return formId;
			}
		}
		
		throw new IntegrationServerConnectorException("Unable to find Form " + formName);
	}
	
	private String findWorkflowQueId( String name ) throws IntegrationServerConnectorException {
		
		List<WorkflowQueueInfo> queues = client.getWorkflowQueueEndpoint().getAllWorkflowQueue().getWorkflowQueues();
		
		for ( WorkflowQueueInfo info : queues)	{
			if ( name.equals(info.getName())) {
				return info.getId();
			}
		}
		throw new IntegrationServerConnectorException( "Unable to find workflow queue" + name );
	}
	
	private String findPageId( String documentId, String name ) throws IntegrationServerConnectorException {
		
		Document doc = client.getDocumentEndpoint().getDocument(documentId);
		List<Page> pages = doc.getPages();		
		
		for ( Page page : pages)	{
			if ( name.equals(page.getName())) {
				return page.getId();
			}
		}
		throw new IntegrationServerConnectorException( "Unable to find page" + name );
	}
}