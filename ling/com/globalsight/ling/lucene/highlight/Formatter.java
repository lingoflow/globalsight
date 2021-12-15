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
package com.globalsight.ling.lucene.highlight;

/**
 * Processes terms found in the original text, typically by applying
 * some form of mark-up to highlight terms in HTML search results
 * pages.
 */
public interface Formatter
{
    /**
     * @param originalText The section of text being considered for
     * markup.
     * @param tokenGroup contains one or several overlapping Tokens
     * along with their scores and positions.
     * @return
     */
    String highlightTerm(String originalText, TokenGroup tokenGroup);
}
