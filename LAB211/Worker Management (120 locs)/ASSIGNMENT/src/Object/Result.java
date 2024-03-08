/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Fpt
 */
public class Result {
    private String id;
    private String fullName;
    private double result;

    public Result() {
    }

    public Result(String id, String fullName, double result) {
        this.id = id;
        this.fullName = fullName;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
    @Override
    public String toString(){
        return String.format("%s | %15s | %7f", id, fullName, result);
    }
}
