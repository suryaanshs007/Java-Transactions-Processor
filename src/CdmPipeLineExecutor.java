public class CdmPipeLineExecutor {
    private CdmPipeLineProcessor cdmp;
    public void displayFilteredResults(String t, String type){
       this.cdmp.filteredStream(t, type).forEach(CdmPipelineBuild.Data::display);
    }
    public void displayReducedResult(String t, String type){
        double res=this.cdmp.averageAmount(t, type);
        double count = this.cdmp.count;
        System.out.println("Average amount transacted within the entered category : " +res/count);
    }

    CdmPipeLineExecutor() {
        this.cdmp= new CdmPipeLineProcessor();
    }

}
