package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge,T valueToEvaluate){
        int dupes = 0;

        for (T ele : array) {
            if(ele.equals(valueToEvaluate)) dupes++;
        }
        for (T ele : arrayToMerge) {
            if(ele.equals(valueToEvaluate)) dupes++;
        }

        return dupes;
    }
    public T getMostCommonFromMerge(T[] arrayToMerge){

        int prevMost = 0;
        T returnMost = null;

        for (T ele : array) {

            int equals = 0;
            for(T x: arrayToMerge){
                if(ele.equals(x)) equals++;
            }

            if(prevMost <equals){
                prevMost = equals;
                returnMost = ele;
            }
        }

        return returnMost;

    }
    public int getNumberOfOccurrences(T valueToEvaluate){
        int countOccurrences = 0;

        for (T ele : array) {
            if (ele.equals(valueToEvaluate)) {
                countOccurrences++;
            }
        }
        return countOccurrences;
    }
    public T[] removeValue(T valueToRemove){


        T[] removed = (T[]) Array.newInstance(valueToRemove.getClass(), this.array.length);
        int size = 0;

        for (T ele : array) {
            if (!ele.equals(valueToRemove)) {
                removed[size++] = ele;
            }
        }

        T[] returnArray = (T[]) Array.newInstance(valueToRemove.getClass(), size);
        for(int i=0; i<size; i++){
            returnArray[i] = removed[i];
        }

        return returnArray;
    }
}
