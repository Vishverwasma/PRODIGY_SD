package TemperatureConvertor.TemperatureConverter.src.main.java.com.ProdigyInfoTech.Task.TemperatureConverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.ProdigyInfoTech.Task.TemperatureConverter.Models.TemperatureConversion;
import com.ProdigyInfoTech.Task.TemperatureConverter.Services.TemperatureConverterService;

@RestController
@RequestMapping("/api")
public class TemperatureConverterController {
	@Autowired
    private final TemperatureConverterService converterService;

    public TemperatureConverterController(TemperatureConverterService converterService) {
        this.converterService = converterService;
    }
    
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/convert")
    public String convertTemperature(
            @RequestParam double temperature,
            @RequestParam String fromUnit,
            @RequestParam String toUnit) {

        TemperatureConversion conversion = new TemperatureConversion();
        conversion.setTemperature(temperature);
        conversion.setFromUnit(fromUnit);
        conversion.setToUnit(toUnit);

        TemperatureConversion result = converterService.convert(conversion);

        return String.format("%.2f %s is %.2f %s",
                result.getTemperature(),
                result.getFromUnit(),
                result.getConvertedTemperature(),
                result.getToUnit());
    }
}
