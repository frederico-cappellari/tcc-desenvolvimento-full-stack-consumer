package br.com.gestaofinanceira.domain.notafiscal.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfNFeDTO {

    public List<ItensNFeDTO> det;
    
    @Override
    public String toString() {
        if (det != null && !det.isEmpty()) {
            StringBuilder sb = new StringBuilder("InfNFeDTO{det=[");
            for (ItensNFeDTO item : det) {
                sb.append(item.toString()).append(", ");
            }
            // Remove the last comma and space
            if (sb.length() > 2) {
                sb.setLength(sb.length() - 2);
            }
            sb.append("]}");
            return sb.toString();
        } else {
            return "InfNFeDTO{det is empty}";
        }
    }
}
