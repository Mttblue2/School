#include <cmath>
#include "ascvd.h"

using namespace std;
double ascvd(bool female, bool white, int age, int tchol, int hdl, int sbp, bool treated, bool smoker, bool dm)
{
	double coefs[15];
	double sum = 0.0;
	double risk = 0.0;
	
	//Validate input
	if(age < 20 || age > 79) return 0;
	if(tchol < 20 || tchol > 1000) return 0;
	if(hdl < 1 || hdl > 200) return 0;
	if(sbp < 30 || sbp > 300) return 0;
	
	//Set coefficients based on race and gender
	if(female && white)
	{
		coefs[0] = -29.799;
		coefs[1] = 4.884;
		coefs[2] = 13.540;
		coefs[3] = -3.114;
		coefs[4] = -13.578;
		coefs[5] = 3.149;
		coefs[6] = 2.019;
		coefs[7] = 0.0;
		coefs[8] = 1.957;
		coefs[9] = 0.0;
		coefs[10] = 7.574;
		coefs[11] = -1.665;
		coefs[12] = 0.661;
		coefs[13] = -29.18;
		coefs[14] = 0.9665;
	}
	else if(female && !white)
	{
		coefs[0] = 17.114;
		coefs[1] = 0.0;
		coefs[2] = 0.940;
		coefs[3] = 0.0;
		coefs[4] = -18.920;
		coefs[5] = 4.475;
		coefs[6] = 29.291;
		coefs[7] = -6.432;
		coefs[8] = 27.820;
		coefs[9] = -6.087;
		coefs[10] = 0.691;
		coefs[11] = 0.0;
		coefs[12] = 0.874;
		coefs[13] = 86.61;
		coefs[14] = 0.9533;
	}
	else if(white)
	{
		coefs[0] = 12.344;
		coefs[1] = 0.0;
		coefs[2] = 11.853;
		coefs[3] = -2.664;
		coefs[4] = -7.990;
		coefs[5] = 1.769;
		coefs[6] = 1.797;
		coefs[7] = 0.0;
		coefs[8] = 1.764;
		coefs[9] = 0.0;
		coefs[10] = 7.837;
		coefs[11] = -1.795;
		coefs[12] = 0.658;
		coefs[13] = 61.18;
		coefs[14] = 0.9144;
	}
	else
	{
		coefs[0] = 2.469;
		coefs[1] = 0.0;
		coefs[2] = 0.302;
		coefs[3] = 0.0;
		coefs[4] = -0.307;
		coefs[5] = 0.0;
		coefs[6] = 1.916;
		coefs[7] = 0.0;
		coefs[8] = 1.809;
		coefs[9] = 0.0;
		coefs[10] = 0.549;
		coefs[11] = 0.0;
		coefs[12] = 0.645;
		coefs[13] = 19.54;
		coefs[14] = 0.8954;
	}
	
	//Calculate adjusted coefficients
	coefs[0]*= log((double)age);
	coefs[1] *= pow(log((double)age), 2);
	coefs[2] *= log((double)tchol);
	coefs[3] *= log((double)age)*log((double)tchol);
	coefs[4] *= log((double)hdl);
	coefs[5] *= log((double)age)*log((double)hdl);
	if(treated)
	{
		coefs[6] *= log((double)sbp);
		coefs[7] *= log((double)age)*log((double)sbp);
		coefs[8] = coefs[9] = 0.0;
	}
	else
	{
		coefs[6] = coefs[7] = 0.0;
		coefs[8] *= log((double)sbp);
		coefs[9] *= log((double)age)*log((double)sbp);
	}
	coefs[10]*= smoker ? 1.0 : 0.0;
	coefs[11] *= smoker ? log((double)age) : 0.0;
	coefs[12]*= dm ? 1.0 : 0.0;
	
	// Calculate risk
	for(int i=0; i<13; i++) sum+= coefs[i];
	risk = 1.0 - pow(coefs[14], exp(sum - coefs[13]));
	return 100*risk;
}
