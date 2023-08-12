--
distroName=$(lsb_release -i | awk '{print $3}')
echo "${distroName}"
