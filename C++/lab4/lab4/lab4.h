#pragma once

/**
* This function determines if Statin Therapy is helpful based on age.
* If the user has had a stroke or heart attack, then Therapy is recommended.
* If the user hasn't, it isn't recommended right away.
**/
int history_risk();

/**
* This function determines if Statin Therapy is helpful based on LDL.
* If the LDL is greater than or equals to 190, then therapy is recommened.
* If the LDL is less than 190, it isn't.
* Perameter is ldl pointer to reference ldl variable in main.
**/
int ldl_risk(int* ldl);

/**
* This function determines if Statin Therapy is helpful based on Age.
* If the age is between 40 and 79, then therapy is recommened.
* If it is anything else, it isn't recommended.
* Perameter is age pointer to reference age variable in main.
**/
int age_risk(int* age);

/**
* This function determines if Statin Therapy is helpful based on if the user is Diabetic.
* If the user is Diabetic, then therapy is recommened.
* If not, it isn't recommended.
* First perameter is dm pointer to reference age variable in main.
* Second perameter is ldl variable.
**/
int dm_risk(bool* dm, int ldl);

/**
* This function determines if Statin Therapy is helpful based on the risk of ASCVD.
* This function asks the user for their gender, race, total-cholesterol, HDL, SBP, blood pressure treatment and smoking status.
* If the the ASCVD is above 7.5, then therapy is recommened.
* If not, it isn't recommended.
* First perameter is int age variable.
* Second perameter is int ldl variable.
* Thirst perameter is bool dm.
**/
int ascvd_risk(int age, int ldl, bool dm);