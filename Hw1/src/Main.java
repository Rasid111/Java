import console.MenuConsole;
import dao.repositories.AccountRamRepository;
import services.AccountService;

void main() {
    var console = new MenuConsole(new AccountService(new AccountRamRepository()));
    console.run();
}
