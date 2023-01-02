#ifndef ASCVD_H

/**
* This function returns ASCVD 10-year risk.
* The value ranges from 0.0, meaning no risk calculated to 100.0, indicating maximal risk.
* Most values, when calculated, are in the range 3.0 to 30.0.
* Pay close attention to the parameter types:
*  female: Bool. true = female, false = male
*  white: Bool. true = white/caucasian, false = not white/not caucasian
*  age: Integer. Calculation only works for age 20 to 79. All other ages return 0.0
*  tchol: Integer. Calculation only works for total cholesterol 20 to 1000. All other values return 0.0.
*  hdl: Integer. Calculation only works for HDL 1 to 200. All other values return 0.0.
*  sbp: Integer. Calculation only works for Systolic Blood Pressure 30 to 300. All other values return 0.0.
*  treated: Bool. true = Taking blood pressure medicine. false = Not taking blood pressure medicine.
*  smoker: Bool. true = current or recent smoker. false = not a smoker.
*  dm: Bool. true = diabetic. false = not diabetic.
*/
double ascvd(bool female, bool white, int age, int tchol, int hdl, int sbp, bool treated, bool smoker, bool dm);

#endif
#define ASCVD_H
