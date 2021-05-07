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

    public static String getRejectionEmailTemplate(String company, String candidate, String role){
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
                "<p>Hi "+candidate+"</p>\n" +
                "<p>Thank you for your interest in "+company+" and for your application for our "+role+" role!</p>\n" +
                "\n" +
                "<p>Unfortunately, after reviewing your background and experience, we won't be moving forward with your candidacy at this time. We have received a great deal of interest in this role, thus we've decided to continue the process with others whose backgrounds align closer to our requirements.\n" +
                "</p>\n" +
                "<p>We are constantly growing our teams and would love for you to continue looking at our careers page for new opportunities as they arise.</p>\n" +
                "<p>Thank you again for your interest in "+company+"! It means the world to us and we hope you continue to be a part of the "+company+" community.</p>\n" +
                "<p>Thanks,<br/>\n" +
                "    "+company+" Staffing Team</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }


}
