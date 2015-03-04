/**
 * Copyright 2015 Fabio Velloso
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.ufscar.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author fabiovelloso
 */
public class CPFValidator implements ConstraintValidator<CPF, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String cpf;
        boolean valido = true;
        cpf = value.trim();

        switch (cpf) {
            case "":
                valido = false;
                break;
            case "00000000000":
                valido = false;
                break;
            case "11111111111":
                valido = false;
                break;
            case "22222222222":
                valido = false;
                break;
            case "33333333333":
                valido = false;
                break;
            case "44444444444":
                valido = false;
                break;
            case "55555555555":
                valido = false;
                break;
            case "66666666666":
                valido = false;
                break;
            case "77777777777":
                valido = false;
                break;
            case "88888888888":
                valido = false;
                break;
            case "99999999999":
                valido = false;
                break;
        }

        if (valido != false) {
            int primeiraSoma=0;
            int segundaSoma=0;
            int primeiroDigito;
            int segundoDigito;
            int resto;
            int aux;
            String digitosCalculados;
            String digitoVerificadorCPF;

            for (int i=1; i < cpf.length()-1; i++) {
                aux = Integer.parseInt(cpf.substring(i-1, i));
                primeiraSoma += (11-i) * aux;
                segundaSoma += (12-i) * aux;
            }
            resto = (primeiraSoma % 11);
            primeiroDigito = (resto < 2) ? 0 : (11-resto);
            segundaSoma += 2 * primeiroDigito;
            resto = (segundaSoma % 11);
            segundoDigito = (resto < 2) ? 0 : (1 -resto);

            digitoVerificadorCPF = cpf.substring(cpf.length()-2, cpf.length());
            digitosCalculados = String.valueOf(primeiroDigito)+String.valueOf(segundoDigito);
            valido = digitoVerificadorCPF.equals(digitosCalculados);
        }
        return valido;
    }

    public static void main(String[] args) {
        CPFValidator cpf = new CPFValidator();
        //  System.out.println(cpf.isValid("00000000000", null));
    }

    @Override
    public void initialize(CPF cpf) {
    }

}
