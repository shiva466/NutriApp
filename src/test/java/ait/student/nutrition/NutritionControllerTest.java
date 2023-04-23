package ait.student.nutrition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ait.student.nutrition.controllers.NutritionController;
import ait.student.nutrition.nutrition.dto.supplier;
import ait.student.nutrition.rep.NutritionRepository;

class NutritionControllerTest {


	  private supplier supplier;

	    @BeforeEach
	    public void setUp() {
	        supplier = new supplier(1L, "Shiva Manufactures", "Books", "Shiva1", "10.00", "20.00", "5.00");
	    }

	    @Test
	    public void testGetId() {
	        assertThat(supplier.getId().longValue()).isEqualTo(1L);
	    }

	    @Test
	    public void testGetSupplier_name() {
	        assertThat(supplier.getSupplier_name()).isEqualTo("Shiva Manufactures");
	    }

	    @Test
	    public void testGetItem() {
	        assertThat(supplier.getItem()).isEqualTo("Books");
	    }

	    @Test
	    public void testGetItem_code() 
	    {
	        assertThat(supplier.getItem_code()).isEqualTo("Shiva1");
	    }

	    @Test
	    public void testGetManufacting_cost() 
	    {
	        assertThat(supplier.getManufacting_cost()).isEqualTo("10.00");
	    }

	    @Test
	    public void testGetSelling_cost() 
	    {
	        assertThat(supplier.getSelling_cost()).isEqualTo("20.00");
	    }

	    @Test
	    public void testGetProfit_gained() {
	        assertThat(supplier.getProfit_gained()).isEqualTo("5.00");
	    }

	    @Test
	    public void testSetSupplier_name() {
	        supplier.setSupplier_name("Paul");
	        assertThat(supplier.getSupplier_name()).isEqualTo("Paul");
	    }

	    @Test
	    public void testSetItem() {
	        supplier.setItem("Pens");
	        assertThat(supplier.getItem()).isEqualTo("Pens");
	    }

	    @Test
	    public void testSetItem_code() {
	        supplier.setItem_code("Pen1");
	        assertThat(supplier.getItem_code()).isEqualTo("Pen1");
	    }

	    @Test
	    public void testSetManufacting_cost() {
	        supplier.setManufacting_cost("15.00");
	        assertThat(supplier.getManufacting_cost()).isEqualTo("15.00");
	    }

	    @Test
	    public void testSetSelling_cost() {
	        supplier.setSelling_cost("25.00");
	        assertThat(supplier.getSelling_cost()).isEqualTo("25.00");
	    }

	    @Test
	    public void testSetProfit_gained() {
	        supplier.setProfit_gained("10.00");
	        assertThat(supplier.getProfit_gained()).isEqualTo("10.00");
	    }
    @Mock
    private NutritionRepository nutritionRepository;

    @InjectMocks
    private NutritionController nutritionController;

    private MockMvc mockNutri;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockNutri = MockMvcBuilders.standaloneSetup(nutritionController).build();
    }

    
    @Test
    void testGetSuppliers() throws Exception {
    	List<supplier> suppliers = new ArrayList<supplier>();
        suppliers.add(new supplier(1L,"Supplier 1", "Item 1", "IC1", "10.0", "15.0", "5.0"));
        suppliers.add(new supplier(2L,"Supplier 2", "Item 2", "IC2", "20.0", "25.0", "5.0"));
        suppliers.add(new supplier(3L,"Supplier 3", "Item 3", "IC3", "30.0", "35.0", "5.0"));
        when(nutritionRepository.findAll(Sort.by("item").descending())).thenReturn(suppliers);
        mockNutri.perform(get("/getsuppliers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].supplier_name").value("Supplier 1"))
                .andExpect(jsonPath("$[0].item").value("Item 1"))
                .andExpect(jsonPath("$[0].item_code").value("IC1"))
                .andExpect(jsonPath("$[0].manufacting_cost").value(10.0))
                .andExpect(jsonPath("$[0].selling_cost").value(15.0))
                .andExpect(jsonPath("$[0].profit_gained").value(5.0))
                .andExpect(jsonPath("$[1].supplier_name").value("Supplier 2"))
                .andExpect(jsonPath("$[1].item").value("Item 2"))
                .andExpect(jsonPath("$[1].item_code").value("IC2"))
                .andExpect(jsonPath("$[1].manufacting_cost").value(20.0))
                .andExpect(jsonPath("$[1].selling_cost").value(25.0))
                .andExpect(jsonPath("$[1].profit_gained").value(5.0))
                .andExpect(jsonPath("$[2].supplier_name").value("Supplier 3"))
                .andExpect(jsonPath("$[2].item").value("Item 3"))
                .andExpect(jsonPath("$[2].item_code").value("IC3"))
                .andExpect(jsonPath("$[2].manufacting_cost").value(30.0))
                .andExpect(jsonPath("$[2].selling_cost").value(35.0))
                .andExpect(jsonPath("$[2].profit_gained").value(5.0));
        
    }
    @Test
    void testGetApplication() {
        Long id = 1L;
        supplier mockSupplier = new supplier(2L, "item", "i1","1", "2", "3", "4");
        mockSupplier.setId(id);
        mockSupplier.setSupplier_name("Mock Supplier");
        mockSupplier.setItem("Mock Item");
        mockSupplier.setItem_code("MCK01");
        Mockito.when(nutritionRepository.findById(id)).thenReturn(Optional.of(mockSupplier));
        Optional<supplier> supplier = nutritionController.getApplication(id);
        assertThat(supplier.isPresent()).isTrue();
        assertThat(supplier.get().getId()).isEqualTo(id);
        assertThat(supplier.get().getSupplier_name()).isEqualTo("Mock Supplier");
        assertThat(supplier.get().getItem()).isEqualTo("Mock Item");
        assertThat(supplier.get().getItem_code()).isEqualTo("MCK01");
    }
	
	@Test public void testCreateSupplier() throws Exception { supplier
	 mockSupplier = new supplier(1L, "Supplier1", "Item1", "IC1", "10.00",
	  "20.00", "10.00");
	  when(nutritionRepository.save(any(supplier.class))).thenReturn(mockSupplier);
	  supplier result = nutritionController.create1(mockSupplier);
	 assertThat(mockSupplier.getId()).isEqualTo(result.getId()); }

}
