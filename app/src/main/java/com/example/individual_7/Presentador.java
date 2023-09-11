package com.example.individual_7;

public class Presentador  {
    public IviewPresenter iViewPresenter;
    private Model modelo;
    public Presentador(IviewPresenter iViewPresenter){
        this.iViewPresenter = iViewPresenter;
        modelo = new Model();
    }


    public void evalPassword(String password) {
        int passwordStrength = modelo.validatePassword(password);
        if (passwordStrength == Model.WEAK) {
            this.iViewPresenter.showWeak();

        } else if (passwordStrength == Model.MEDIUM) {
            this.iViewPresenter.showMedium();

        } else if (passwordStrength == Model.STRONG) {
            this.iViewPresenter.showStrong();

        } else {
            this.iViewPresenter.showError();
        }
    }
}
