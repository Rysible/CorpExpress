// mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8081'


package managment.model;

// import com.example.ordermanagement.model.*;
// import com.example.ordermanagement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private PartItemLinkRepository partItemLinkRepository;

    // Home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("itemCount", itemRepository.count());
        model.addAttribute("contactCount", contactPersonRepository.count());
        model.addAttribute("companyCount", companyRepository.count());
        model.addAttribute("partCount", partRepository.count());
        return "home";
    }

    // =============== CONTACT PERSON CONTROLLER METHODS ===============

    @GetMapping("/contacts")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactPersonRepository.findAll());
        return "contacts/list";
    }

    @GetMapping("/contacts/new")
    public String newContactForm(Model model) {
        model.addAttribute("contact", new ContactPerson());
        return "contacts/form";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContactForm(@PathVariable("id") Integer id, Model model) {
        Optional<ContactPerson> contact = contactPersonRepository.findById(id);
        if (contact.isPresent()) {
            model.addAttribute("contact", contact.get());
            return "contacts/form";
        }
        return "redirect:/contacts";
    }

    @PostMapping("/contacts/save")
    public String saveContact(@ModelAttribute ContactPerson contact, RedirectAttributes redirectAttributes) {
        contactPersonRepository.save(contact);
        redirectAttributes.addFlashAttribute("message", "Contact saved successfully!");
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/delete/{id}")
    public String deleteContact(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        contactPersonRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Contact deleted successfully!");
        return "redirect:/contacts";
    }

    // =============== COMPANY CONTROLLER METHODS ===============

    @GetMapping("/companies")
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "companies/list";
    }

    @GetMapping("/companies/new")
    public String newCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "companies/form";
    }

    @GetMapping("/companies/edit/{id}")
    public String editCompanyForm(@PathVariable("id") Integer id, Model model) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            model.addAttribute("company", company.get());
            return "companies/form";
        }
        return "redirect:/companies";
    }

    @PostMapping("/companies/save")
    public String saveCompany(@ModelAttribute Company company, RedirectAttributes redirectAttributes) {
        companyRepository.save(company);
        redirectAttributes.addFlashAttribute("message", "Company saved successfully!");
        return "redirect:/companies";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        companyRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Company deleted successfully!");
        return "redirect:/companies";
    }

    // =============== ITEM CONTROLLER METHODS ===============

    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "items/list";
    }

    @GetMapping("/items/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("contacts", contactPersonRepository.findAll());
        model.addAttribute("companies", companyRepository.findAll());
        return "items/form";
    }

    @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable("id") Integer id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            model.addAttribute("contacts", contactPersonRepository.findAll());
            model.addAttribute("companies", companyRepository.findAll());
            return "items/form";
        }
        return "redirect:/items";
    }

    @PostMapping("/items/save")
    public String saveItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        itemRepository.save(item);
        redirectAttributes.addFlashAttribute("message", "Item saved successfully!");
        return "redirect:/items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        itemRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Item deleted successfully!");
        return "redirect:/items";
    }

    @GetMapping("/items/{id}/parts")
    public String itemParts(@PathVariable("id") Integer id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            model.addAttribute("parts", partRepository.findAll());
            List<PartItemLink> links = partItemLinkRepository.findByItemItemID(id);
            model.addAttribute("partLinks", links);
            return "items/parts";
        }
        return "redirect:/items";
    }

    // =============== PART CONTROLLER METHODS ===============

    @GetMapping("/parts")
    public String listParts(Model model) {
        model.addAttribute("parts", partRepository.findAll());
        return "parts/list";
    }

    @GetMapping("/parts/new")
    public String newPartForm(Model model) {
        model.addAttribute("part", new Part());
        return "parts/form";
    }

    @GetMapping("/parts/edit/{id}")
    public String editPartForm(@PathVariable("id") Integer id, Model model) {
        Optional<Part> part = partRepository.findById(id);
        if (part.isPresent()) {
            model.addAttribute("part", part.get());
            return "parts/form";
        }
        return "redirect:/parts";
    }

    @PostMapping("/parts/save")
    public String savePart(@ModelAttribute Part part, RedirectAttributes redirectAttributes) {
        partRepository.save(part);
        redirectAttributes.addFlashAttribute("message", "Part saved successfully!");
        return "redirect:/parts";
    }

    @GetMapping("/parts/delete/{id}")
    public String deletePart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        partRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Part deleted successfully!");
        return "redirect:/parts";
    }

    // =============== PART-ITEM LINK CONTROLLER METHODS ===============

    @PostMapping("/items/{itemId}/add-part")
    public String addPartToItem(@PathVariable("itemId") Integer itemId,
                                @RequestParam("partId") Integer partId,
                                @RequestParam("quantity") Integer quantity,
                                RedirectAttributes redirectAttributes) {
        Optional<Item> itemOpt = itemRepository.findById(itemId);
        Optional<Part> partOpt = partRepository.findById(partId);

        if (itemOpt.isPresent() && partOpt.isPresent()) {
            Item item = itemOpt.get();
            Part part = partOpt.get();

            PartItemLinkId linkId = new PartItemLinkId(partId, itemId);
            PartItemLink link = new PartItemLink();
            link.setId(linkId);
            link.setItem(item);
            link.setPart(part);
            link.setPartQuantity(quantity);

            partItemLinkRepository.save(link);

            redirectAttributes.addFlashAttribute("message", "Part added to item successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Part or Item not found!");
        }

        return "redirect:/items/" + itemId + "/parts";
    }

    @GetMapping("/items/{itemId}/remove-part/{partId}")
    public String removePartFromItem(@PathVariable("itemId") Integer itemId,
                                     @PathVariable("partId") Integer partId,
                                     RedirectAttributes redirectAttributes) {
        PartItemLinkId linkId = new PartItemLinkId(partId, itemId);
        partItemLinkRepository.deleteById(linkId);
        redirectAttributes.addFlashAttribute("message", "Part removed from item successfully!");
        return "redirect:/items/" + itemId + "/parts";
    }
}