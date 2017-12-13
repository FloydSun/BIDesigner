
CREATE TABLE dim_index (
                index_name_key INT AUTO_INCREMENT NOT NULL,
                index_name VARCHAR(128) NOT NULL,
                PRIMARY KEY (index_name_key)
);


CREATE TABLE dim_index_closure (
                child_index_name_key INT NOT NULL,
                parent_index_name_key INT NOT NULL,
                distance INT NOT NULL,
                PRIMARY KEY (child_index_name_key)
);


CREATE TABLE dim_organization (
                organization_key INT AUTO_INCREMENT NOT NULL,
                organization_name VARCHAR(128) NOT NULL,
                PRIMARY KEY (organization_key)
);


CREATE TABLE dim_organization_closure (
                child_organization_key INT NOT NULL,
                parent_organization_key INT NOT NULL,
                distance INT NOT NULL,
                PRIMARY KEY (child_organization_key)
);


CREATE TABLE dim_date (
                date_key INT NOT NULL,
                date DATE NOT NULL,
                date_short CHAR(12) NOT NULL,
                date_medium CHAR(16) NOT NULL,
                date_long CHAR(24) NOT NULL,
                date_full CHAR(32) NOT NULL,
                day_in_year SMALLINT NOT NULL,
                day_in_month TINYINT NOT NULL,
                is_first_day_in_month CHAR(10) NOT NULL,
                is_last_day_in_month CHAR(10) NOT NULL,
                day_abbreviation CHAR(3) NOT NULL,
                day_name CHAR(12) NOT NULL,
                week_in_year TINYINT NOT NULL,
                week_in_month TINYINT NOT NULL,
                is_first_day_in_week CHAR(10) NOT NULL,
                is_last_day_in_week CHAR(10) NOT NULL,
                month_number TINYINT NOT NULL,
                month_abbreviation CHAR(3) NOT NULL,
                month_name CHAR(12) NOT NULL,
                year2 CHAR(2) NOT NULL,
                year4 SMALLINT NOT NULL,
                quarter_name CHAR(2) NOT NULL,
                quarter_number TINYINT NOT NULL,
                year_quarter CHAR(7) NOT NULL,
                year_month_number CHAR(7) NOT NULL,
                year_month_abbreviation CHAR(8) NOT NULL,
                PRIMARY KEY (date_key)
);


CREATE TABLE fact_index_value_monthly (
                index_value_id INT NOT NULL,
                date_key INT NOT NULL,
                organization_key INT NOT NULL,
                index_name_key INT NOT NULL,
                plan_value NUMERIC,
                actual_value NUMERIC,
                PRIMARY KEY (index_value_id)
);


ALTER TABLE dim_index_closure ADD CONSTRAINT dim_index_dim_index_closure_fk
FOREIGN KEY (child_index_name_key)
REFERENCES dim_index (index_name_key)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE fact_index_value_monthly ADD CONSTRAINT dim_index_closure_fact_index_value_monthly_fk
FOREIGN KEY (index_name_key)
REFERENCES dim_index_closure (child_index_name_key)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE dim_organization_closure ADD CONSTRAINT dim_organization_dim_organization_closure_fk
FOREIGN KEY (child_organization_key)
REFERENCES dim_organization (organization_key)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE fact_index_value_monthly ADD CONSTRAINT dim_organization_closure_fact_index_value_monthly_fk
FOREIGN KEY (organization_key)
REFERENCES dim_organization_closure (child_organization_key)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE fact_index_value_monthly ADD CONSTRAINT dim_date_fact_index_value_monthly_fk
FOREIGN KEY (date_key)
REFERENCES dim_date (date_key)
ON DELETE NO ACTION
ON UPDATE NO ACTION;