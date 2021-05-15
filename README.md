# cmpe282-Artemis - Job Portal

## Actors
<li>Employer/Company</li>
<li>User/Applicant</li>

# Feature Set
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

## Architecture Diagram
![sample (2)](https://user-images.githubusercontent.com/37695314/118344120-8cee4980-b4e1-11eb-8a58-c55258375f3f.png)

