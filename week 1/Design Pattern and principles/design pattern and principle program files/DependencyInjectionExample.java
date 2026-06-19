interface CustomerRepository {
    void findCustomerById(int id);
}
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void findCustomerById(int id) {
        System.out.println("Customer found with ID : " + id);
    }
}
class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void getCustomer(int id) {
        repository.findCustomerById(id);
    }
}
public class DependencyInjectionExample {

    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.getCustomer(101);
    }
}