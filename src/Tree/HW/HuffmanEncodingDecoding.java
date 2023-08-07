package Tree.HW;

    //implement hoffman's encoding and decoding
    import java.util.*;

    class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    public class HuffmanEncodingDecoding {

        public static Map<Character, String> encode(String text) {
            Map<Character, Integer> frequencyMap = calculateFrequency(text);
            Node root = buildHuffmanTree(frequencyMap);
            Map<Character, String> codeMap = generateCodeMap(root);
            return codeMap;
        }

        public static String decode(String encodedText, Map<Character, String> codeMap) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < encodedText.length()) {
                Node node = getMatchingNode(encodedText, i, codeMap);
                sb.append(node.ch);
                i += node.freq;
            }
            return sb.toString();
        }

        private static Map<Character, Integer> calculateFrequency(String text) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (char ch : text.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
            return frequencyMap;
        }

        private static Node buildHuffmanTree(Map<Character, Integer> frequencyMap) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                pq.offer(new Node(entry.getKey(), entry.getValue(), null, null));
            }

            while (pq.size() > 1) {
                Node left = pq.poll();
                Node right = pq.poll();
                Node parent = new Node('\0', left.freq + right.freq, left, right);
                pq.offer(parent);
            }

            return pq.poll();
        }

        private static Map<Character, String> generateCodeMap(Node root) {
            Map<Character, String> codeMap = new HashMap<>();
            generateCode(root, "", codeMap);
            return codeMap;
        }

        private static void generateCode(Node node, String code, Map<Character, String> codeMap) {
            if (node.left == null && node.right == null) {
                codeMap.put(node.ch, code);
                return;
            }
            generateCode(node.left, code + "0", codeMap);
            generateCode(node.right, code + "1", codeMap);
        }

        private static Node getMatchingNode(String encodedText, int startIndex, Map<Character, String> codeMap) {
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                String code = entry.getValue();
                if (startIndex + code.length() <= encodedText.length() && encodedText.substring(startIndex, startIndex + code.length()).equals(code)) {
                    return new Node(entry.getKey(), code.length(), null, null);
                }
            }
            throw new IllegalArgumentException("Invalid encoded text or code map.");
        }

        public static void main(String[] args) {
            String text = "hello world";
            Map<Character, String> codeMap = encode(text);
            String encodedText = "";
            for (char ch : text.toCharArray()) {
                encodedText += codeMap.get(ch);
            }
            System.out.println("Encoded Text: " + encodedText);
            System.out.println("Decoded Text: " + decode(encodedText, codeMap));
        }
    }


