package br.com.cwi.crescer.lavanderia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;
import br.com.cwi.crescer.lavanderia.services.ItemService;

@Controller
@RequestMapping("/itens")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(path = "/processartodos", method = RequestMethod.POST)
    public ModelAndView processarTudo(@ModelAttribute("pedido") PedidoDTO dto,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("mensagem", "Pedido processado com sucesso!");

        itemService.processarTodosItensDoPedido(dto);
        return new ModelAndView("redirect:/pedidos/" + dto.getIdPedido());
    }

    @RequestMapping(path = "/processar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute("pedido") PedidoDTO dto,
            RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Long idItem = Long.parseLong(request.getParameter("idItem"));

        redirectAttributes.addFlashAttribute("mensagem", "Item do pedido processado com sucesso!");

        itemService.processarItemDoPedido(idItem, dto);
        return new ModelAndView("redirect:/pedidos/" + dto.getIdPedido());
    }
}
