package example.musiweather.app.infrastructure.openweathermap.mapper;


import example.musiweather.app.core.domain.Weather;
import example.musiweather.app.infrastructure.openweathermap.dto.OpenWeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Open weather dto domain mapper.
 */
@Mapper // use componentModel="spring" to use DI (dependency injection) for inject bean in spring context
public interface OpenWeatherDTODomainMapper {
    /**
     * The constant INSTANCE.
     */
    OpenWeatherDTODomainMapper INSTANCE = Mappers.getMapper(OpenWeatherDTODomainMapper.class); // if not using DI

    /**
     * To domain weather.
     *
     * @param openWeatherDTO the open weather dto
     * @return the weather
     */
    @Mapping(source =  "openWeatherDTO.temp.current", target = "currentTemperature")
    Weather toDomain(OpenWeatherDTO openWeatherDTO);
}
