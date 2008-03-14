/*
 * Copyright 2008 National Library of Sweden 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software 
 * distributed  under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package se.kb.oai.pmh;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

/**
 * This class represents the response from a <code>ListMetadataFormats</code> request 
 * to the OAI-PMH server.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class MetadataFormatsList extends ResponseBase {

    private static final String METADATAFORMAT_XPATH = "oai:ListMetadataFormats/oai:metadataFormat";
    
    private List<MetadataFormat> metadataFormats;
    
    /**
     * Creates a <code>MetadataFormatsList</code> from the returned response.
     * 
     * @param document the response
     * @throws ErrorResponseException
     */
    public MetadataFormatsList(Document document) throws ErrorResponseException {
        super(document);
        
        this.metadataFormats = new LinkedList<MetadataFormat>();
        for(Node metadataFormat : xpath.selectNodes(METADATAFORMAT_XPATH)) {
            metadataFormats.add(new MetadataFormat(metadataFormat));
        }
    }
    
    /**
     * Get the size of the list.
     * 
     * @return the size
     */
    public int size() {
        return metadataFormats.size();
    }
    
    /**
     * Get the metadata formats as a list of <code>MetadataFormats</code>.
     * 
     * @return a list of metadata formats
     */
    public List<MetadataFormat> asList() {
        return metadataFormats;
    } 
}
