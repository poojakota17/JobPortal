# cmpe282-Artemis - Job Portal

## Actors
<li>Employer/Company</li>
<li>User/Applicant</li>

# Functionalities
## Recruiter
- Recruiters can register their companies and add themselves in the portal
- Recruiters  can post job vacancies and job description with deadline
- Recruiters will be able to shortlist or reject candidates and notify them
- To assist Recruiter in shortlisting applications :
   -  Amazon Textract, ML service  used for PDF screening 
   - Calculated score for candidates based on their skills and job description : Right person at the right job
- Recruiter can schedule interview in  Zoom and notify applicant with the joining url.

## Candidate
- Candidates can  search for jobs : used Elasticsearch as search engine
- Candidates will be notified to their email about their application status 
- Candidates can join Zoom for virtual interview

## Features Implemented and the Services Used
- R53 for Domain Routing : Low latency leveraging CloudFront
- Auto Scaling and Load balancing through Elastic Beanstalk.
- Okta based SSO
- Role based access control
- Leveraged Machine Learning services like Amazon Textract
- Lambda functions for different services.
- Cloud based database : SQL and NOSQL as per requirements.
- ElasticSearch search engine used by indexing DynamoDB tables.
- Third Party Integration : Zoom
- API driven architecture.
- Continuous Deployment through Jenkins and Elastic Beanstalk
- SendGrid for email service

## Architecture Diagram
![sample (2)](https://user-images.githubusercontent.com/37695314/118344120-8cee4980-b4e1-11eb-8a58-c55258375f3f.png)

