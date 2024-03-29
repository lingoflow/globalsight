package com.globalsight.cxe.entity.filterconfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.globalsight.everest.util.comparator.FilterComparator;
import com.globalsight.persistence.hibernate.HibernateUtil;
import com.globalsight.util.SortUtil;

public class JsonFilter implements Filter
{

    private static final Logger log = Logger.getLogger(JsonFilter.class);

    private long id;
    private String filterName;
    private String filterDescription;
    private boolean enableSidSupport = false;
    private long companyId;
    private long elementPostFilterId;
    private long baseFilterId;
    private String elementPostFilterTableName;

    public String getElementPostFilterTableName()
    {
        return elementPostFilterTableName;
    }

    public void setElementPostFilterTableName(String elementPostFilterTableName)
    {
        this.elementPostFilterTableName = elementPostFilterTableName;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFilterName()
    {
        return filterName;
    }

    public void setFilterName(String filterName)
    {
        this.filterName = filterName;
    }

    public String getFilterDescription()
    {
        return filterDescription;
    }

    public void setFilterDescription(String filterDescription)
    {
        this.filterDescription = filterDescription;
    }

    public boolean isEnableSidSupport()
    {
        return enableSidSupport;
    }

    public void setEnableSidSupport(boolean enableSidSupport)
    {
        this.enableSidSupport = enableSidSupport;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(long companyId)
    {
        this.companyId = companyId;
    }

    public long getElementPostFilterId()
    {
        return elementPostFilterId;
    }

    public void setElementPostFilterId(long elementPostFilterId)
    {
        this.elementPostFilterId = elementPostFilterId;
    }

    public long getBaseFilterId()
    {
        return baseFilterId;
    }

    public void setBaseFilterId(long baseFilterId)
    {
        this.baseFilterId = baseFilterId;
    }

    public boolean checkExistsNew(String filterName, long companyId)
    {
        String hql = "from JsonFilter jf where jf.filterName =:filterName and jf.companyId=:companyId";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("filterName", filterName);
        map.put("companyId", companyId);

        return HibernateUtil.search(hql, map).size() > 0;
    }

    public boolean checkExistsEdit(long filterId, String filterName, long companyId)
    {
        String hql = "from JsonFilter jf where jf.id<>:filterId and jf.filterName =:filterName and jf.companyId=:companyId";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("filterId", filterId);
        map.put("filterName", filterName);
        map.put("companyId", companyId);
        return HibernateUtil.search(hql, map).size() > 0;
    }

    public String getFilterTableName()
    {
        return FilterConstants.JSON_TABLENAME;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Filter> getFilters(long companyId)
    {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        String hql = "from JsonFilter jf where jf.companyId=" + companyId;
        filters = (ArrayList<Filter>) HibernateUtil.search(hql);
        SortUtil.sort(filters, new FilterComparator(Locale.getDefault()));
        return filters;
    }

    public String toJSON(long companyId)
    {
        JSONObject json = new JSONObject();
        try
        {
            json.put("id", id);
            json.put("companyId", companyId);
            json.put("filterName", filterName);
            json.put("filterDescription", filterDescription);
            json.put("enableSidSupport", enableSidSupport);
            json.put("elementPostFilterId", elementPostFilterId);
            json.put("elementPostFilterTableName", elementPostFilterTableName);
            json.put("baseFilterId", baseFilterId);
            json.put("filterTableName", FilterConstants.JSON_TABLENAME);
        }
        catch (JSONException e)
        {
            log.error("Failure to construct JSON into jsonfilter. "+e);
        }
        return json.toString();
    }

}
