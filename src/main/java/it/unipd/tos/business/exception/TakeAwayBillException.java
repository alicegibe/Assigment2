////////////////////////////////////////////////////////////////////
// alice gibellato 1197756
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {

    private String mex;

    public TakeAwayBillException(String err) {
        this.mex = err;
    }

    public String getMessage() {
        return this.mex;
    }
}