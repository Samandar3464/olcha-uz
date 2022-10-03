package uz.pdp.modul;
// product bn categoriya ga  1 ta id generatsiya boldi
public class Category extends  Base {
   private int parentId;

   public Category(int parentId) {
      this.parentId = parentId;
   }

   public Category() {
   }

   public int getParentId() {
      return parentId;
   }

   public void setParentId(int parentId) {
      this.parentId = parentId;
   }

   @Override
   public String toString() {
      return "Category{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", parentId=" + parentId +
              '}';
   }
}
