import java.util.ArrayList;

/* 
    4.7 Build Order - You are given a list of projects and a list of dependencies (which is a list of pairs of
    projects, where the second project is dependent on the first project.) All of the project's dependencies must
    be built before the project is. Find a build order that will allow the projects to be built. If there is no
    valid build order, return an error.

    Example
        Input: 
            Projects: a, b, c, d, e, f
            Dependencies: (a, b), (f, b), (b, d), (f, a), (d, c)
        Output: f, e, a, b, d, c
    
    TODO: STILL UNFINISHED
*/

public class BuildOrder{

    public static class Dependency{
        String first;
        String second;

        public Dependency(String first, String second){
            this.first = first;
            this.second = second;
        }

    }

    public static void main(String[] args){
        ArrayList<Dependency> testDependencies = new ArrayList<Dependency>();
        testDependencies.add(new Dependency("a", "b"));
        testDependencies.add(new Dependency("f", "b"));
        testDependencies.add(new Dependency("b", "d"));
        testDependencies.add(new Dependency("f", "a"));
        testDependencies.add(new Dependency("d", "c"));
        ArrayList<String> testProjects = new ArrayList<String>();
        testProjects.add("a");
        testProjects.add("b");
        testProjects.add("c");
        testProjects.add("d");
        testProjects.add("e");
        testProjects.add("f");
        ArrayList<String> results = getBuildOrder(testProjects, testDependencies);
        for(String project : results){
            System.out.print(project+" ");
        }
    }

    /* 
        Input: 
            Projects: a, b, c, d, e, f
            Dependencies: (a, b), (f, b), (b, d), (f, a), (d, c)
        Output: f, e, a, b, d, c
    */
    public static ArrayList<String> getBuildOrder(ArrayList<String> projects, ArrayList<Dependency> dependencies){
        ArrayList<String> result = new ArrayList<String>();
        Graph projectGraph = new Graph();
        return result;
    }


}