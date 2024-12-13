package com.example.nearby.data.model.mock

import com.example.nearby.data.model.Market
import com.example.nearby.data.model.Rule

val mockMarkets = listOf(
    Market(
        id = "d23f446a-b424-4247-8551-fbeab622d988",
        categoryId = "2",
        name = "Verde Vivo",
        description = "Sua alimentação saudável em um só lugar. Frutas, verduras, legumes orgânicos e produtos naturais.",
        coupons = 5,
//        rules = listOf(
//            Rule(
//                id = "1",
//                description = "Válido até o dia 31/12/2024",
//                marketId = "d23f446a-b424-4247-8551-fbeab622d988"
//            ),
//            Rule(
//                id = "2",
//                description = "Disponível apenas para consumo no local",
//                marketId = "d23f446a-b424-4247-8551-fbeab622d988"
//            )
//        ),
        latitude = -23.563837,
        longitude = -46.652346,
        address = "Rua da Saúde, 123 - Vila Madalena",
        phone = "(11) 88888-8888",
        cover = "https://images.unsplash.com/photo-1565964733820-91ba14fdae27?w=400&h=300"
    ),
    Market(
        id = "a12b334a-b424-4247-8551-fbeab622d988",
        categoryId = "3",
        name = "Feira dos Artesãos",
        description = "O melhor da arte e da criatividade. Encontre peças únicas e exclusivas de diversos artistas.",
        coupons = 0,
//        rules = emptyList(),
        latitude = -23.573837,
        longitude = -46.642346,
        address = "Praça da Liberdade, 456 - Centro",
        phone = "(11) 77777-7777",
        cover = "https://images.unsplash.com/photo-1508615038070-bdc57d9346a3?w=400&h=300"
    ),
    Market(
        id = "b78c990a-b424-4247-8551-fbeab622d988",
        categoryId = "1",
        name = "Tech Store",
        description = "A sua loja de eletrônicos com os melhores preços e condições de pagamento.",
        coupons = 20,
//        rules = emptyList(),
        latitude = -23.593837,
        longitude = -46.622346,
        address = "Rua Augusta, 901 - Jardins",
        phone = "(11) 55555-5555",
        cover = "https://images.unsplash.com/photo-1505740420928-5e5c63606d30?w=400&h=300"
    ),
    Market(
        id = "6844fb6a-b424-4247-8551-fbeab622d988",
        categoryId = "1",
        name = "Sabor Grill",
        description = "Melhor hamburgueria artesenal da região, diversos blind e de alta qualidade, com o sabor inigualável.",
        coupons = 10,
//        rules = emptyList(),
        latitude = -23.55974230991911,
        longitude = -46.6581485249887,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 99999-9999",
        cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    )
)