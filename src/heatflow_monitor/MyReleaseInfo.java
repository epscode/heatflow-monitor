/* Created by JReleaseInfo AntTask from Open Source Competence Group */
/* Creation date Mon Apr 25 13:38:49 PDT 2022 */
package heatflow_monitor;

import java.util.Date;

/**
 * This class provides information gathered from the build environment.
 * 
 * @author JReleaseInfo AntTask
 */
public class MyReleaseInfo {


   /** buildDate (set during build process to 1650919129245L). */
   private static Date buildDate = new Date(1650919129245L);

   /**
    * Get buildDate (set during build process to Mon Apr 25 13:38:49 PDT 2022).
    * @return Date buildDate
    */
   public static final Date getBuildDate() { return buildDate; }


   /** project (set during build process to "Heatflow Monitor"). */
   private static String project = "Heatflow Monitor";

   /**
    * Get project (set during build process to "Heatflow Monitor").
    * @return String project
    */
   public static final String getProject() { return project; }


   /** buildTimeStamp (set during build process to "time to go"). */
   private static String buildTimeStamp = "time to go";

   /**
    * Get buildTimeStamp (set during build process to "time to go").
    * @return String buildTimeStamp
    */
   public static final String getBuildTimeStamp() { return buildTimeStamp; }


   /** copyright (set during build process to "2022, Brecky Morris and The University of California, Santa Cruz"). */
   private static String copyright = "2022, Brecky Morris and The University of California, Santa Cruz";

   /**
    * Get copyright (set during build process to "2022, Brecky Morris and The University of California, Santa Cruz").
    * @return String copyright
    */
   public static final String getCopyright() { return copyright; }


   /** mail (set during build process to "brecky.morris@ucsc.edu"). */
   private static String mail = "brecky.morris@ucsc.edu";

   /**
    * Get mail (set during build process to "brecky.morris@ucsc.edu").
    * @return String mail
    */
   public static final String getMail() { return mail; }


   /** version (set during build process to "1.0"). */
   private static String version = "1.0";

   /**
    * Get version (set during build process to "1.0").
    * @return String version
    */
   public static final String getVersion() { return version; }


   /** company (set during build process to "University of California, Santa Cruz"). */
   private static String company = "University of California, Santa Cruz";

   /**
    * Get company (set during build process to "University of California, Santa Cruz").
    * @return String company
    */
   public static final String getCompany() { return company; }


   /**
    * Get buildNumber (set during build process to 2970).
    * @return int buildNumber
    */
   public static final int getBuildNumber() { return 2970; }


   /** home (set during build process to "http://eps.ucsc.edu/"). */
   private static String home = "http://eps.ucsc.edu/";

   /**
    * Get home (set during build process to "http://eps.ucsc.edu/").
    * @return String home
    */
   public static final String getHome() { return home; }

}
