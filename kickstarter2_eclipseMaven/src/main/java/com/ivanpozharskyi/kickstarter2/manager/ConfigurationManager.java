package com.ivanpozharskyi.kickstarter2.manager;
import java.util.ResourceBundle;

public class ConfigurationManager {
      private static ConfigurationManager instance;
      private ResourceBundle resourceBundle;

      private static final String BUNDLE_NAME = "com.ivanpozharskyi.kickstarter2.manager.config";
      public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
      public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
      public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
      public static final String CATEGORIES_PAGE_PATH = "CATEGORIES_PAGE_PATH";
      public static final String PROJECTS_PAGE_PATH = "PROJECTS_PAGE_PATH";
      public static final String PROJECTINFO_PAGE_PATH = "PROJECTINFO_PAGE_PATH";
      public static final String REGISTRATION_PAGE_PATH = "REGISTRATION_PAGE_PATH";


      public static ConfigurationManager getInstance(){
          if (instance == null){
              instance = new ConfigurationManager();
              instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
          }
          return instance;
      }
      public String getProperty(String key){
          return (String) resourceBundle.getObject(key);
      }
}