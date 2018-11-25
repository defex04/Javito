CREATE TABLE public."main"
(
    id integer NOT NULL,
    "time" text COLLATE pg_catalog."default" NOT NULL,
    "usd_rate" real NOT NULL,
    "gbp_rate" real NOT NULL,
    "eur_rate" real NOT NULL,
    CONSTRAINT "main_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."main"
    OWNER to postgres;

CREATE TABLE public."eur_predict"
(
    id_predict integer NOT NULL,
    "predict_val_eur" real NOT NULL,
    increase_decrease boolean NOT NULL,
    CONSTRAINT "eur_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."eur_predict"
    OWNER to postgres;

CREATE TABLE public."eur_id_predict"
(
    "id_eur_predict" integer NOT NULL,
    "id_eur" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "eur_id_predict_pkey" PRIMARY KEY ("id_eur_predict"),
    CONSTRAINT "eur_id_predict_id_eur_fkey" FOREIGN KEY ("id_eur")
        REFERENCES public."main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "eur_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."eur_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."eur_id_predict"
    OWNER to postgres;

-- Table: public."GBP_predict"

-- DROP TABLE public."GBP_predict";

CREATE TABLE public."gbp_predict"
(
    id_predict integer NOT NULL,
    "predict_val_gbp" real NOT NULL,
    increase_decrease boolean NOT NULL,
    CONSTRAINT "gbp_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."gbp_predict"
    OWNER to postgres;

-- Table: public."GBP_id_predict"

-- DROP TABLE public."GBP_id_predict";

CREATE TABLE public."gbp_id_predict"
(
    "id_gbp_predict" integer NOT NULL,
    "id_gbp" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "gbp_id_predict_pkey" PRIMARY KEY ("id_gbp_predict"),
    CONSTRAINT "gbp_id_predict_id_gbp_fkey" FOREIGN KEY ("id_gbp")
        REFERENCES public."main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "gbp_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."gbp_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."gbp_id_predict"
    OWNER to postgres;

-- Table: public."usd_predict";

CREATE TABLE public."usd_predict"
(
    "predict_val_usd" real NOT NULL,
    increase_decrease boolean NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "usd_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."usd_predict"
    OWNER to postgres;

-- Table: public."USD_id_predict"

-- DROP TABLE public."USD_id_predict";

CREATE TABLE public."usd_id_predict"
(
    "id_usd_predict" integer NOT NULL,
    "id_usd" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "usd_id_predict_pkey" PRIMARY KEY ("id_usd_predict"),
    CONSTRAINT "usd_id_predict_id_usd_predict_fkey" FOREIGN KEY ("id_usd_predict")
        REFERENCES public."main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "usd_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."usd_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."usd_id_predict"
    OWNER to postgres;

-- Table: public."Day"

-- DROP TABLE public."Day";

CREATE TABLE public."day"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    CONSTRAINT "day_pkey" PRIMARY KEY (id),
    CONSTRAINT "day_id_day_key" UNIQUE (id_day)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."day"
    OWNER to postgres;

-- Table: public."EUR_min_max"

-- DROP TABLE public."EUR_min_max";

CREATE TABLE public."eur_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "eur_max" real NOT NULL,
    "eur_min" real NOT NULL,
    CONSTRAINT "eur_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "eur_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."eur_min_max"
    OWNER to postgres;

-- Table: public."GBP_min_max"

-- DROP TABLE public."GBP_min_max";

CREATE TABLE public."gbp_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "gbp_max" real NOT NULL,
    "gbp_min" real NOT NULL,
    CONSTRAINT "gbp_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "gbp_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."gbp_min_max"
    OWNER to postgres;

-- Table: public."USD_min_max"

-- DROP TABLE public."USD_min_max";

CREATE TABLE public."usd_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "usd_max" real NOT NULL,
    "usd_min" real NOT NULL,
    CONSTRAINT "usd_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "usd_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."usd_min_max"
    OWNER to postgres;