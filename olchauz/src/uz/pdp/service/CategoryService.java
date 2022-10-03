package uz.pdp.service;

import uz.pdp.dataBase.DataBase;
import uz.pdp.modul.Category;

public class CategoryService implements BaseService, DataBase {

    public boolean addCategory(Category category) {
        for (Category category1 : categories) {
            if (category1.getName().equals(category.getName())) {
                return false;
            }
        }
        categories.add(category);
        return true;
    }

    @Override
    public boolean delete(int categoryId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == categoryId) {
                    categories.remove(category);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int id) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == id) {
                    return category;
                }
            }
        }
        return null;
    }

    public void showParentCategoriesforAdmin() {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == 0) {
                    System.out.println(category);
                }
            }
        }
    }

    public void showAllCategories() {
        for (Category category : categories) {
            if (category != null) {
                System.out.println(category);
            }
        }
    }

    public void showSubCategoriesForAdmin(int parentId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == parentId) {
                    System.out.println(category);
                }
            }
        }
    }

    public Category showParentCategoriesforUser() {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == 0) {
                    System.out.println(category);
                    return  category;
                }
            }
        }
        return null;
    }
    public Category showSubCategoriesForUser(int parentId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == parentId) {
                    System.out.println(category);
                    return  category;
                }
            }
        }
        return null;
    }
}
