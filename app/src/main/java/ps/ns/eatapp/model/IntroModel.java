package ps.ns.eatapp.model;


public class IntroModel {

    int imageIntro;
    String titleIntro;
    String descriptionIntro;


    public IntroModel(int imageIntro, String titleIntro, String descriptionIntro) {
        this.imageIntro = imageIntro;
        this.titleIntro = titleIntro;
        this.descriptionIntro = descriptionIntro;
    }


    public int getImageIntro() {
        return imageIntro;
    }

    public void setImageIntro(int imageIntro) {
        this.imageIntro = imageIntro;
    }

    public String getTitleIntro() {
        return titleIntro;
    }

    public void setTitleIntro(String titleIntro) {
        this.titleIntro = titleIntro;
    }

    public String getDescriptionIntro() {
        return descriptionIntro;
    }

    public void setDescriptionIntro(String descriptionIntro) {
        this.descriptionIntro = descriptionIntro;
    }
}
