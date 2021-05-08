package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.enums.Status;
import com.cmpe282.artemis.jobportal.utils.EmailUtil;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailService {
    public Response sendEmail(JobApplication jobApplication) throws IOException {
        Email from = new Email("jeena.thampi@sjsu.edu");
        String subject = "Thanks for applying to "+jobApplication.getJobPost().getCompany().getName();
        Email to = new Email(jobApplication.getCandidate().getEmail());
        String candidateName = jobApplication.getCandidate().getFirstName()+" "+jobApplication.getCandidate().getLastName();
        String companyName = jobApplication.getJobPost().getCompany().getName();
        Content content = null;
        if(jobApplication.getStatus().equals(Status.APPLIED)){
            content = new Content("text/html", EmailUtil.getConfirmationEmailTemplate(companyName, candidateName));
        } else if(jobApplication.getStatus().equals(Status.REJECT)){
            content = new Content("text/html",EmailUtil.getRejectionEmailTemplate(companyName, candidateName, jobApplication.getJobPost().getRole()));
        }
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
        return response;
    }
}
