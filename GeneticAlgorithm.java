import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToDoubleFunction;

public class GeneticAlgorithm {

    private String generate(int length) {
        String result = "";
        for(int i = 0; i < length; i++){
            result += Math.round(Math.random());
        }
        return result;
    }

    private String[] select(List<String> population, List<Double> fitnesses) {
        String[] result = new String[2];
        int index = -1;
        for(int i = 0; i < result.length; i++) {
            Optional<Double> wheel = fitnesses.stream().reduce(Double::sum);
            double spin = Math.random() * wheel.get();
            for (int j = 0; j < population.size(); j++) {
                if (spin <= fitnesses.get(j) && index != i) {
                    result[i] = population.get(j);
                    index = i;
                    break;
                }
            }
            if(result[i] == null){
                i--;
            }
        }
        return result;
    }

    private String mutate(String chromosome, double p) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < chromosome.length(); i++){
            double check = Math.random();
            if(check <= p){
                result.append(chromosome.charAt(i) == '1' ? '0' : '1');
            }else{
                result.append(chromosome.charAt(i));
            }
        }
        return result.toString();
    }

    private String[] crossover(String chromosome1, String chromosome2) {
        int randomBit = ThreadLocalRandom.current().nextInt(1, chromosome1.length());
        String cross1 = "",cross2 = "";
        for(int i = 0; i < chromosome1.length(); i++){
            if(i < randomBit) {
                cross1 += chromosome1.charAt(i);
                cross2 += chromosome2.charAt(i);
            }else{
                cross1 += chromosome2.charAt(i);
                cross2 += chromosome1.charAt(i);
            }
        }
        return new String[]{cross1,cross2};
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        return run(fitness,length,p_c,p_m,100);
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        List<String> population = new ArrayList<>();
        List<Double> fitnesses = new ArrayList<>();
        int popSize = 100;
        for(int i = 0; i < popSize; i++){
            population.add(generate(length));
        }
        for (int j = 0; j < popSize; j++) {
            fitnesses.add(fitness.applyAsDouble(population.get(j)));
        }
        for(int i = 0; i < iterations; i++) {
            List<String> newPop = new ArrayList<>();
            for (int j = 0; j < popSize / 2; j++) {
                String[] temp = select(population, fitnesses);
                if (Math.random() <= p_c) {
                    temp = crossover(temp[0], temp[1]);
                    temp[0] = mutate(temp[0], p_m);
                    temp[1] = mutate(temp[1], p_m);
                }
                newPop.add(temp[0]);
                newPop.add(temp[1]);
            }
            population = newPop;
            fitnesses.clear();
            for (int j = 0; j < popSize; j++) {
                fitnesses.add(fitness.applyAsDouble(population.get(j)));
            }
        }
        int maxIndex = 0;
        double maxFit = 0;
        for(int i = 0; i < fitnesses.size(); i++){
            if(maxFit < fitnesses.get(i)){
                maxFit = fitnesses.get(i);
                maxIndex = i;
            }
        }
        return population.get(maxIndex);
    }
}
