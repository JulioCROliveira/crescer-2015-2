package br.com.cwi.crescer.lavanderia.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;
import br.com.cwi.crescer.lavanderia.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoSituacaoController extends PedidoController {

    @Autowired
    public PedidoSituacaoController(PedidoService pedidoService) {
        super(pedidoService);
    }

    @RequestMapping(path = "/cancelar", method = RequestMethod.POST)
    public ModelAndView cancelar(@ModelAttribute("pedido") PedidoDTO dto,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("mensagem", "Pedido cancelado com sucesso!");

        pedidoService.cancelarPedido(dto);
        return new ModelAndView("redirect:/pedidos/");
    }

    @RequestMapping(path = "/retirar", method = RequestMethod.POST)
    public ModelAndView retirar(@ModelAttribute("pedido") PedidoDTO dto,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("mensagem", "Pedido retirado com sucesso!");

        pedidoService.retirarPedido(dto);
        return new ModelAndView("redirect:/pedidos/");
    }
}
