PGDMP  +                     }            consultor_libros    13.16    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    30668    consultor_libros    DATABASE     �   CREATE DATABASE consultor_libros WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Latin America.1252';
     DROP DATABASE consultor_libros;
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    30671    libro    TABLE     �   CREATE TABLE public.libro (
    id bigint NOT NULL,
    titulo character varying(255) NOT NULL,
    idioma character varying(255) NOT NULL,
    anio_publicacion integer,
    autores text[]
);
    DROP TABLE public.libro;
       public         heap    postgres    false    4            �            1259    30690    libro_autores    TABLE     h   CREATE TABLE public.libro_autores (
    libro_id bigint NOT NULL,
    autores character varying(255)
);
 !   DROP TABLE public.libro_autores;
       public         heap    postgres    false    4            �            1259    30669    libro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.libro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.libro_id_seq;
       public          postgres    false    4    201            �           0    0    libro_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.libro_id_seq OWNED BY public.libro.id;
          public          postgres    false    200            '           2604    30680    libro id    DEFAULT     d   ALTER TABLE ONLY public.libro ALTER COLUMN id SET DEFAULT nextval('public.libro_id_seq'::regclass);
 7   ALTER TABLE public.libro ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            �          0    30671    libro 
   TABLE DATA           N   COPY public.libro (id, titulo, idioma, anio_publicacion, autores) FROM stdin;
    public          postgres    false    201   �       �          0    30690    libro_autores 
   TABLE DATA           :   COPY public.libro_autores (libro_id, autores) FROM stdin;
    public          postgres    false    202   S       �           0    0    libro_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.libro_id_seq', 2, true);
          public          postgres    false    200            )           2606    30682    libro libro_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.libro DROP CONSTRAINT libro_pkey;
       public            postgres    false    201            *           2606    30693 )   libro_autores fksoheqe18ertlksjno9y33x0am    FK CONSTRAINT     �   ALTER TABLE ONLY public.libro_autores
    ADD CONSTRAINT fksoheqe18ertlksjno9y33x0am FOREIGN KEY (libro_id) REFERENCES public.libro(id);
 S   ALTER TABLE ONLY public.libro_autores DROP CONSTRAINT fksoheqe18ertlksjno9y33x0am;
       public          postgres    false    202    201    2857            �   H   x�3�LK-�K�K�W(�L�J-��L-�4202���2�LN,J,K�K,VH,J�L�+ʦ����qqq ���      �   /   x�3�LK-�K�K��2�L,�2�LN,��/2�J��2�b���� ��v     