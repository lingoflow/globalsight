/*
 * Copyright (c) 2000 GlobalSight Corporation. All rights reserved.
 *
 * THIS DOCUMENT CONTAINS TRADE SECRET DATA WHICH IS THE PROPERTY OF
 * GLOBALSIGHT CORPORATION. THIS DOCUMENT IS SUBMITTED TO RECIPIENT
 * IN CONFIDENCE. INFORMATION CONTAINED HEREIN MAY NOT BE USED, COPIED
 * OR DISCLOSED IN WHOLE OR IN PART EXCEPT AS PERMITTED BY WRITTEN
 * AGREEMENT SIGNED BY AN OFFICER OF GLOBALSIGHT CORPORATION.
 *
 * THIS MATERIAL IS ALSO COPYRIGHTED AS AN UNPUBLISHED WORK UNDER
 * SECTIONS 104 AND 408 OF TITLE 17 OF THE UNITED STATES CODE.
 * UNAUTHORIZED USE, COPYING OR OTHER REPRODUCTION IS PROHIBITED
 * BY LAW.
 */

package com.globalsight.everest.projecthandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.globalsight.everest.page.SourcePage;
import com.globalsight.persistence.hibernate.HibernateUtil;

import junit.framework.TestCase;

public class ProjectImplTest extends TestCase
{
    private static Set ids = new HashSet();
    private static Long defaultId = new Long(10001);
    
    private List getIds()
    {
        ArrayList idList = new ArrayList();
        if (ids.size() == 0)
        {
            idList.add(defaultId);
        }
        else
        {
            idList = new ArrayList(ids);
        }
        return idList;
    }

    public void testSave() throws Exception
    {
        Set uIds = new HashSet();
        uIds.add("sdf");
        
        SourcePage source = new SourcePage();
        source.setId(1);
        
        ProjectImpl impl = new ProjectImpl();

        impl.setName("name");
        impl.setManagerUserId("121");
        impl.setCompanyId("2");
        impl.setUserIds(uIds);

        
        HibernateUtil.save(impl);
        System.out.println(impl.getUserIds().size());

        ids.add(new Long(impl.getId()));
        System.out.println("Save id: " + impl.getId());
    }
    
    public void testSaveNoNull() throws Exception
    {
        SourcePage source = new SourcePage();
        source.setId(1);
        
        ProjectImpl impl = new ProjectImpl();

        impl.setName("name");
        impl.setManagerUserId("121");
        impl.setCompanyId("3");
        impl.setDescription("d");
        impl.setTermbaseName("s");
        impl.setQuoteUserId("s");

        
        HibernateUtil.save(impl);

        ids.add(new Long(impl.getId()));
        System.out.println("Save id: " + impl.getId());
    }
    
    public void testGet() throws Exception
    {
        List ids = getIds();

        for (int i = 0; i < ids.size(); i++)
        {
            Long id = (Long)ids.get(i);
            System.out.println("id: " + id);
            ProjectImpl object = (ProjectImpl) HibernateUtil.get(
                    ProjectImpl.class, id);
            System.out.println(object.getQuoteUserId());
        }
    }

    public void testDelete() throws Exception
    {
        List ids = getIds();

        for (int i = 0; i < ids.size(); i++)
        {
            ProjectImpl impl = new ProjectImpl();
            Long id = (Long)ids.get(i);
            impl.setId(id.longValue());

            impl.setName("name");
            impl.setManagerUserId("121");
            impl.setCompanyId("c");
            
            System.out.println("Delete id: " + id);
            HibernateUtil.delete(impl);         
        }
    }
}
