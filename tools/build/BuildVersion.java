package com.globalsight;
public class BuildVersion
{
    /** Product Name **/
    public static final String PRODUCT="GlobalSight";
    
    /** Product Version **/
    public static final String VERSION="${version}";
    
    /** Build Date **/
    public static final String BUILD_DATE="20170310";
    
    /**the build version will get displayed in the about box **/
    public static final String BUILD_VERSION="${version}";
    
    /** Prints out the Build version info **/ 
    public static void main(String args[])
    {
        System.out.println(PRODUCT + " version: " + VERSION);    
        System.out.println("Build version: " + BUILD_VERSION);
        System.out.println("Build date: " + BUILD_DATE);        
    }
}
