CREATE TABLE co.t_ingredients
(
    ingredient_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    PRIMARY KEY (ingredient_id)
);

CREATE TABLE co.t_cocktails
(
    cocktail_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    url character varying(1000) NOT NULL,
    PRIMARY KEY (cocktail_id)
);

CREATE TABLE co.t_cocktails_x_ingredients
(
    cocktail_id bigserial NOT NULL,
    ingredient_id bigserial NOT NULL,
    FOREIGN KEY (cocktail_id)
        REFERENCES co.t_cocktails (cocktail_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (ingredient_id)
        REFERENCES co.t_ingredients (ingredient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);