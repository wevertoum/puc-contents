
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        while (true) {

            String[] options = {"Nova Operação", "Sair"};
            int menuChoice = JOptionPane.showOptionDialog(null, "Bem-vindo à Calculadora Segura!", "Calculadora",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (menuChoice == 1 || menuChoice == -1) {
                break;
            }

            try {

                double num1 = getNumberFromUser("Digite o primeiro número:");
                double num2 = getNumberFromUser("Digite o segundo número:");

                String[] operations = {"Adição (+)", "Subtração (-)", "Multiplicação (*)", "Divisão (/)"};
                int opChoice = JOptionPane.showOptionDialog(null, "Escolha a operação matemática:", "Operação",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);

                if (opChoice == -1) {
                    continue;
                }

                calculateAndShowResult(num1, num2, opChoice);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Erro: Por favor, insira apenas números válidos.",
                        "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException e) {

                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro Matemático", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {

                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Calculadora encerrada.");
    }

    private static double getNumberFromUser(String message) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(message);
        if (input == null) {

            throw new NumberFormatException("Operação cancelada pelo usuário.");
        }
        return Double.parseDouble(input.replace(',', '.'));
    }

    private static void calculateAndShowResult(double num1, double num2, int operationIndex) throws ArithmeticException {
        double result = 0;
        String operationSymbol = "";

        switch (operationIndex) {
            case 0 -> {

                result = num1 + num2;
                operationSymbol = "+";
            }
            case 1 -> {

                result = num1 - num2;
                operationSymbol = "-";
            }
            case 2 -> {

                result = num1 * num2;
                operationSymbol = "*";
            }
            case 3 -> {

                if (num2 == 0) {

                    throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
                }
                result = num1 / num2;
                operationSymbol = "/";
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Nenhuma operação selecionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        String message = String.format("Resultado: %.2f %s %.2f = %.2f", num1, operationSymbol, num2, result);
        JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}
