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
package com.globalsight.everest.webapp.pagehandler.administration.costing.currency;

import com.globalsight.everest.servlet.EnvoyServletException;
import com.globalsight.everest.servlet.util.SessionManager;
import com.globalsight.everest.webapp.WebAppConstants;
import com.globalsight.everest.webapp.pagehandler.PageHandler;
import com.globalsight.everest.webapp.webnavigation.WebPageDescriptor;
import com.globalsight.everest.costing.Currency;
import com.globalsight.persistence.hibernate.HibernateUtil;
import com.globalsight.util.GeneralException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.Vector;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Pagehandler for the new/edit Currency page
 */
public class CurrencyBasicHandler extends PageHandler
        implements CurrencyConstants
{
    /**
     * Invokes this PageHandler
     *
     * @param pageDescriptor the page desciptor
     * @param request the original request sent from the browser
     * @param response the original response object
     * @param context context the Servlet context
     */
    public void invokePageHandler(WebPageDescriptor p_pageDescriptor,
        HttpServletRequest p_request, HttpServletResponse p_response,
        ServletContext p_context)
        throws ServletException, IOException, EnvoyServletException
    {
        HttpSession session = p_request.getSession(false);
        String action = p_request.getParameter("action");

        try
        {
            Locale uiLocale = (Locale) session.getAttribute(WebAppConstants.USER_UI_LOCALE);
            if (action.equals(CurrencyConstants.CREATE))
            {
                setIsoCurrencies(session, p_request);
            }
            else if (action.equals(CurrencyConstants.EDIT))
            {
                // Fetch the currency to edit and store in session
                String currenyID = (String) p_request
                        .getParameter("currencyId");
                Currency curr = HibernateUtil.get(Currency.class,
                        Long.parseLong(currenyID));
                SessionManager sessionMgr = (SessionManager)
                    session.getAttribute(WebAppConstants.SESSION_MANAGER);
                sessionMgr.setAttribute(CurrencyConstants.CURRENCY, curr);
                p_request.setAttribute("edit", "true");
            }

            // set pivot currency in request
            Currency pivot = CurrencyHandlerHelper.getPivotCurrency();
            if (pivot != null)
                    p_request.setAttribute("pivot", pivot.getDisplayName(uiLocale));
        }
        catch (NamingException ne)
        {
            throw new EnvoyServletException(EnvoyServletException.EX_GENERAL, ne);
        }
        catch (RemoteException re)
        {
            throw new EnvoyServletException(EnvoyServletException.EX_GENERAL, re);
        }
        catch (GeneralException ge)
        {
            throw new EnvoyServletException(EnvoyServletException.EX_GENERAL, ge);
        }
        super.invokePageHandler(p_pageDescriptor, p_request, p_response, p_context);
    }

    private void setIsoCurrencies(HttpSession p_session, HttpServletRequest p_request)
    throws NamingException, RemoteException, GeneralException
    {
        Vector isos = CurrencyHandlerHelper.getAllIsoCurrencies();
        p_request.setAttribute(CurrencyConstants.ISO_CURRENCY, isos);
    }
}


