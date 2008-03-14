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

import org.dom4j.Node;
import org.w3c.dom.Document;

public class SetsList extends ResponseBase {

    private static final String SET_XPATH = "oai:ListSets/oai:set";
    
    private List<Set> sets;
    
    public SetsList(Document document) throws ErrorResponseException {
        super(document);
        
        this.sets = new LinkedList<Set>();
        for (Node set : xpath.selectNodes(SET_XPATH)) {
            sets.add(new Set(set));
        }
    }
    
    public int size() {
        return sets.size();
    }

    public List<Set> asList() {
        return sets;
    }
}