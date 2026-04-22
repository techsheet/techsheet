<?php
define('DB_NAME', 'wordpress');
define('DB_USER', 'root');
define('DB_PASSWORD', '');
define('DB_HOST', 'localhost');
$table_prefix = 'wp_';
if (!defined('ABSPATH')) {
  define('ABSPATH', __DIR__ . '/');
}
require_once ABSPATH . 'wp-settings.php';
