package com.cmpe282.artemis.jobportal.utils;

public class ZoomNotificationEmailUtil {
    public static String zoomConfirmationEmailTemplate(String candidateName, String companyName,String role,String duration,String time,String url) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Page Title</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            text-align: left;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<p>Hi "+candidateName+"</p>\n" +
                "<p>Thanks for applying to "+companyName+"! There are a ton of great companies out there, so we appreciate your interest in joining our team.</p>\n" +
                "\n" +
                "<p>We would like to invite you to interview for the role of "+role+". The interview will last for "+duration+" minutes in total.\n" +
                "\n" +
                "Please reply with your availability during the following date and time option: "+time+".</p>\n" +
                "\n" +
                "If you are available, please join with the following url on zoom at the scheduled time \n" +
                "\n" +
                "Joining url: "+url+"\n" +
                "\n" +
                "<p>Thanks,<br/>\n" +
                "    "+companyName+" Staffing Team</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

}
