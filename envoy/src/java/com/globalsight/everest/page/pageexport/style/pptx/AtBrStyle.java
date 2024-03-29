/**
 *  Copyright 2009 Welocalize, Inc. 
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  
 *  You may obtain a copy of the License at 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */
package com.globalsight.everest.page.pageexport.style.pptx;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * A style class extends Bold style
 */
public class AtBrStyle extends Style
{

    /**
     * @see com.globalsight.everest.page.pageexport.style.docx.Style#getNodeName()
     */
    @Override
    protected String getNodeName()
    {
        return "atBr";
    }

    /**
     * @see com.globalsight.everest.page.pageexport.style.docx.Style#getAddNodeName()
     */
    @Override
    public String getAddNodeName()
    {
        return "atBr";
    }

    /**
     * @see com.globalsight.everest.page.pageexport.style.docx.Style#getAddNodeValue()
     */
    @Override
    protected String getAddNodeValue()
    {
        return null;
    }

//	@Override
//	public String getStyle() 
//	{
//		return "atStyle";
//	}
	
    /**
     * Adds style to the pptx document. Should not be null.
     * 
     * @param document
     *            the document that maybe have style node.
     * @return the number of found tag
     */
	@Override
	public void handleStyleNode(Node bNode)
    {
        Node wtNode = bNode.getParentNode();
        if (wtNode == null)
        	return;
        
        Node wrNode = wtNode.getParentNode();
        if (wrNode == null)
        	return;
        
        Node root = wrNode.getParentNode();
        if (root == null)
        	return;

        if (wrNode.getNodeName().equals("a:r"))
        {
            Node cNode = wtNode.getFirstChild();
            
            while (cNode != null)
            {
                Node cloneNode = wrNode.cloneNode(true);

                updateStyle(cNode, cloneNode, wtNode, wrNode, root);

                cNode = cNode.getNextSibling();
            }

            root.removeChild(wrNode);
        }
    }
	
	@Override
	protected void updateStyle(Node cNode, Node cloneNode, Node wtNode,
			Node wrNode, Node root)
    {
        if (cNode.getNodeName().equals(getNodeName()))
        {

        	Node wr = cNode.cloneNode(true);
        	root.insertBefore(wr, wrNode);
        	removeNode(wr);
            // Style node can be nested.
        }
        else
        {
        	changeText(cloneNode, wtNode.getNodeName(), cNode);
        	root.insertBefore(cloneNode, wrNode);
        }
	}
	
	protected void changeText(Node node, String textName, Node styleNode)
    {
        Node t = getChild(node, textName);

        if (t != null)
        {
            if (styleNode.getNodeType() == Node.TEXT_NODE)
            {
                t.setTextContent(styleNode.getTextContent());
            }
            else if (styleNode.getNodeName().equals(getNodeName()))
            {
                // clean the node.
                t.setTextContent("");
                Node cNode = styleNode.getFirstChild();
                while (cNode != null)
                {
                    t.appendChild(cNode.cloneNode(true));
                    cNode = cNode.getNextSibling();
                }
            }
            else
            {
                t.setTextContent("");
                t.appendChild(styleNode.cloneNode(true));
            }
        }
    }
}
