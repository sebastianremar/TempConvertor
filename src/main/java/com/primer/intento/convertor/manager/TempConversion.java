package com.primer.intento.convertor.manager;

public interface TempConversion {
    /**
     *
     * @return
     */
    public double CToF(double currentTemp);
    /**
     *
     * @return
     */
    public double CToK(double currentTemp);
    /**
     *
     * @return
     */
    public double FToC(double currentTemp);
    /**
     *
     * @return
     */
    public double FToK(double currentTemp);
    /**
     *
     * @return
     */
    public double KToC(double currentTemp);
    /**
     *
     * @return
     */
    public double KToF(double currentTemp);
}
