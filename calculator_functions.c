//
// Created by Saikat Mondal on 10-01-2019.
//

#include <jni.h>
#include <stdio.h>
#include <math.h>

double factorial(double n1)
{
    if(n1<2)return 1;
    return n1*factorial(n1-1);
}

JNIEXPORT jdouble JNICALL
Java_com_example_saikatmondal_calculator_MainActivity_getAnswer(
        JNIEnv* env,
        jobject jo,double input1,double input2,char operation) {
    //std::string hello = "Hello from C++";
    //return env->NewStringUTF(hello.c_str());
    switch(operation){
        case '+' :
            return input1+input2;
            break;
        case '-' :
            return input1-input2;
            break;
        case 'x' :
            return input1*input2;
            break;
        case '/' :
            return input1/input2;
            break;
        case 's' :
            return sin(M_PI*input1/180.0);
            break;
        case 'c' :
            return cos(M_PI*input1/180.0);
            break;
        case 't' :
            return tan(M_PI*input1/180.0);
            break;
        case 'r' :
            return sqrt(input1);
            break;
        case 'p' :
            return pow(input1,input2);
            break;
        case 'f' :
            return factorial(input1);
            break;
    }

}
