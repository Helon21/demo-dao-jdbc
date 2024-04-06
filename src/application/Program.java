package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n=== TEST1 SELLER findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("\n=== TEST2 SELLER findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST3 SELLER findAll === ");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n ===TEST4 SELLER insert === ");
        Seller newSeller = new Seller(null, "Heloísa", "heloisa@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());

        System.out.println("\n TEST5 SELLER update == ");
        seller = sellerDao.findById(7);
        seller.setName("Hinata");
        sellerDao.update(seller);
        System.out.println("Update completed");
    }

}
