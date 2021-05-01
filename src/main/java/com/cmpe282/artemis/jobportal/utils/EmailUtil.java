package com.cmpe282.artemis.jobportal.utils;

public class EmailUtil {

    public static String getConfirmationEmailTemplate(String companyName, String candidateName) {
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
                "<p>While we’re not able to reach out to every applicant, our recruiting team will contact you if your skills and experience are a strong match for the role.</p>\n" +
                "\n" +
                "<p>Thanks,<br/>\n" +
                "    "+companyName+" Staffing Team</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }


}
