CREATE TABLE public."Main"
(
    id integer NOT NULL,
    "time" text COLLATE pg_catalog."default" NOT NULL,
    "USD_rate" real NOT NULL,
    "GBP_rate" real NOT NULL,
    "EUR_rate" real NOT NULL,
    CONSTRAINT "Main_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Main"
    OWNER to postgres;

CREATE TABLE public."EUR_predict"
(
    id_predict integer NOT NULL,
    "predict_val_EUR" real NOT NULL,
    increase_decrease boolean NOT NULL,
    CONSTRAINT "EUR_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."EUR_predict"
    OWNER to postgres;


CREATE TABLE public."EUR_id_predict"
(
    "id_EUR_predict" integer NOT NULL,
    "id_EUR" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "EUR_id_predict_pkey" PRIMARY KEY ("id_EUR_predict"),
    CONSTRAINT "EUR_id_predict_id_EUR_fkey" FOREIGN KEY ("id_EUR")
        REFERENCES public."Main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "EUR_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."EUR_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."EUR_id_predict"
    OWNER to postgres;

-- Table: public."GBP_predict"

-- DROP TABLE public."GBP_predict";

CREATE TABLE public."GBP_predict"
(
    id_predict integer NOT NULL,
    "predict_val_GBP" real NOT NULL,
    increase_decrease boolean NOT NULL,
    CONSTRAINT "GBP_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."GBP_predict"
    OWNER to postgres;

-- Table: public."GBP_id_predict"

-- DROP TABLE public."GBP_id_predict";

CREATE TABLE public."GBP_id_predict"
(
    "id_GBP_predict" integer NOT NULL,
    "id_GBP" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "GBP_id_predict_pkey" PRIMARY KEY ("id_GBP_predict"),
    CONSTRAINT "GBP_id_predict_id_GBP_fkey" FOREIGN KEY ("id_GBP")
        REFERENCES public."Main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "GBP_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."GBP_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."GBP_id_predict"
    OWNER to postgres;

- Table: public."USD_predict";

CREATE TABLE public."USD_predict"
(
    "predict_val_USD" real NOT NULL,
    increase_decrease boolean NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "USD_predict_pkey" PRIMARY KEY (id_predict)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."USD_predict"
    OWNER to postgres;

-- Table: public."USD_id_predict"

-- DROP TABLE public."USD_id_predict";

CREATE TABLE public."USD_id_predict"
(
    "id_USD_predict" integer NOT NULL,
    "id_USD" integer NOT NULL,
    id_predict integer NOT NULL,
    CONSTRAINT "USD_id_predict_pkey" PRIMARY KEY ("id_USD_predict"),
    CONSTRAINT "USD_id_predict_id_USD_predict_fkey" FOREIGN KEY ("id_USD_predict")
        REFERENCES public."Main" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "USD_id_predict_id_predict_fkey" FOREIGN KEY (id_predict)
        REFERENCES public."USD_predict" (id_predict) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."USD_id_predict"
    OWNER to postgres;

-- Table: public."Day"

-- DROP TABLE public."Day";

CREATE TABLE public."Day"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    CONSTRAINT "Day_pkey" PRIMARY KEY (id),
    CONSTRAINT "Day_id_day_key" UNIQUE (id_day)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Day"
    OWNER to postgres;

-- Table: public."EUR_min_max"

-- DROP TABLE public."EUR_min_max";

CREATE TABLE public."EUR_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "EUR_max" real NOT NULL,
    "EUR_min" real NOT NULL,
    CONSTRAINT "EUR_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "EUR_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."Day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."EUR_min_max"
    OWNER to postgres;

-- Table: public."GBP_min_max"

-- DROP TABLE public."GBP_min_max";

CREATE TABLE public."GBP_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "GBP_max" real NOT NULL,
    "GBP_min" real NOT NULL,
    CONSTRAINT "GBP_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "GBP_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."Day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."GBP_min_max"
    OWNER to postgres;

-- Table: public."USD_min_max"

-- DROP TABLE public."USD_min_max";

CREATE TABLE public."USD_min_max"
(
    id integer NOT NULL,
    id_day integer NOT NULL,
    "USD_max" real NOT NULL,
    "USD_min" real NOT NULL,
    CONSTRAINT "USD_min_max_pkey" PRIMARY KEY (id),
    CONSTRAINT "USD_min_max_id_day_fkey" FOREIGN KEY (id_day)
        REFERENCES public."Day" (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."USD_min_max"
    OWNER to postgres;